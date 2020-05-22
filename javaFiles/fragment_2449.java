package com.mycompany.myapp;

import com.mycompany.myapp.model.BaseEntity;
import com.mycompany.myapp.util.ReflectUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareMixin;

import java.util.Objects;

@Aspect
public class BaseEntityObservabilityAspect {
    @DeclareMixin("com.mycompany.myapp.model.BaseEntity")
    public static ChangeSupport createChangeSupportImplementation(final BaseEntity baseEntity) {
        return new ChangeSupportImpl(baseEntity);
    }

    // Intercept setters in all BaseEntity objects in order to notify about property change
    @Around("this(baseEntity) && execution(public void set*(*))")
    public void firePropertyChange(final BaseEntity baseEntity,
            final ProceedingJoinPoint joinPoint) throws Throwable {
        // Get property name from method name
        final String setterName = joinPoint.getSignature().getName();
        final String property = setterName.substring(3, 4).toLowerCase() + setterName.substring(4);
        final ChangeSupport support = (ChangeSupport)baseEntity;
        if (support.hasListeners(property)) {
            // Get old value via reflection
            final Object oldValue = ReflectUtils.invokeGetter(baseEntity, property);

            // Proceed with the invocation of the method
            joinPoint.proceed();

            // New value is the first (and only) argument of this method
            final Object newValue = joinPoint.getArgs()[0];
            // Fire only if value actually changed
            if (!Objects.equals(oldValue, newValue))
                support.firePropertyChange(property, oldValue, newValue);
        } else {
            // No listeners have been registered with BaseEntity, so there is no need to fire property change event
            joinPoint.proceed();
        }
    }
}