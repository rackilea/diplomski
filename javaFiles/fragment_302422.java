package de.scrum_master.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareError;

@Aspect
public class PointcutChecker {
    @DeclareError(
        "execution(* *(..)) && " +
        "@annotation(de.scrum_master.app.MyCustomAnnotation) && " +
        "!execution(* *(*, java.util.Map<String, Object>))"
    )
    static final String wrongSignatureError =
        "wrong method signature for @MyCustomAnnotation";
}