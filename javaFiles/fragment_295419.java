package de.scrum_master.aspect;

import java.lang.reflect.Field;
import java.util.Random;
import org.aspectj.lang.SoftException;
import de.scrum_master.app.InjectServiceClientAdapter;

public aspect StaticInjectionAspect {
    private static final Random RANDOM = new Random();

    before(InjectServiceClientAdapter adapterAnn, Object targetObj) :
        get(* *) && @annotation(adapterAnn) && target(targetObj)
    {
        try {
            Field field = targetObj.getClass().getDeclaredField(thisJoinPoint.getSignature().getName());
            field.setAccessible(true);
            if (field.get(targetObj) != null)
                return;
            Class<?> implClass = RANDOM.nextBoolean() ? adapterAnn.legacyImpl() : adapterAnn.newImpl();
            field.set(targetObj,implClass.newInstance());
        } catch (Exception e) {
            throw new SoftException(e);
        }
    }
}