package de.scrum_master.aspect;

import java.util.HashSet;
import java.util.Set;

import org.apache.http.auth.AuthenticationException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.mobile.peakgames.net.aspectjandroid.AspectActivity;
import android.util.Log;

@Aspect
public class ExceptionHandlingAspect {
  private static final String TAG = ExceptionHandlingAspect.class.getName();

  private Set<Throwable> ignoredErrors = new HashSet<>();

  @Pointcut("execution(* *(..)) && target(activity)")
  public void methodsOfInterest(AspectActivity activity) {}

  @Pointcut("@annotation(android.mobile.peakgames.net.aspectjandroid.exception.NoTryCatch)")
  public void annotationNoTryCatch() {}

  @Around("methodsOfInterest(activity) && !annotationNoTryCatch()")
  public Object exceptionAroundMethod(ProceedingJoinPoint thisJoinPoint, AspectActivity activity) throws Throwable {
    try {
      return thisJoinPoint.proceed();
    } catch (Throwable throwable) {
      if (ignoredErrors.contains(throwable))
        throw throwable;
      String errorMessage = "Error " + throwable + " in method " + thisJoinPoint.getSignature();
      Log.e(TAG, errorMessage);
      Builder builder = new AlertDialog.Builder(activity);
      if (throwable instanceof AuthenticationException)
        builder.setTitle("Authentication Error").setMessage("You are not authenticated").show();
      else
        builder.setTitle("Error").setMessage(errorMessage).show();
      return null;
    }
  }

  @AfterThrowing(value = "methodsOfInterest(activity) && annotationNoTryCatch()", throwing = "throwable")
  public void ignoreExceptions(JoinPoint thisJoinPoint, AspectActivity activity, Throwable throwable) {
    ignoredErrors.add(throwable);
  }
}