package com.mycompany.myapp;

import java.util.Objects;

import com.mycompany.myapp.model.BaseEntity;
import com.mycompany.myapp.util.ReflectUtils;

public aspect BaseEntityObservabilityAspect {
    declare parents: BaseEntity extends ChangeSupportImpl;

    // Intercept setters in all BaseEntity objects in order to notify about property change
    void around(final BaseEntity entity, final ChangeSupport support):
            this(entity) && this(support) && execution(public void BaseEntity+.set*(*)) {
        // Get property name from method name
        final String setterName = thisJoinPoint.getSignature().getName();
        final String property = setterName.substring(3, 4).toLowerCase() + setterName.substring(4);
        if (support.hasListeners(property)) {
            final Object oldValue;
            try {
                // Get old value via reflection
                oldValue = ReflectUtils.invokeGetter(entity, property);
            } catch (final Throwable e) {
                // Should not happen
                proceed(entity, support);
                return;
            }

            // Proceed with the invocation of the method
            proceed(entity, support);

            // New value is the first (and only) argument of this method
            final Object newValue = thisJoinPoint.getArgs()[0];
            // Fire only if value actually changed
            if (!Objects.equals(oldValue, newValue))
                support.firePropertyChange(property, oldValue, newValue);
        } else {
            // No listeners have been registered with BaseEntity, so there is no need to fire property change event
            proceed(entity, support);
        }
    }
}