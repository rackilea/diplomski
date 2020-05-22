package de.scrum_master.aspect;

import java.util.Random;
import org.aspectj.lang.SoftException;
import de.scrum_master.app.InjectServiceClientAdapter;

public aspect DynamicInjectionAspect {
    private static final Random RANDOM = new Random();

    Object around(InjectServiceClientAdapter adapterAnn) :
        get(* *) && @annotation(adapterAnn)
    {
        try {
            Class<?> implClass = RANDOM.nextBoolean() ? adapterAnn.legacyImpl() : adapterAnn.newImpl();
            return implClass.newInstance();
        } catch (Exception e) {
            throw new SoftException(e);
        }
    }
}