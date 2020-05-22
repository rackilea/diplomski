package de.scrum_master.aspect;

import com.amazon.carbonado.Storable;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class CarbonadoAspect {
  @Around("call(boolean tryLoad()) && target(storable)")
  public boolean tryInsertIfNotFound(ProceedingJoinPoint thisJoinPoint, Storable storable) throws Throwable {
    System.out.println(thisJoinPoint);
    if ((boolean) thisJoinPoint.proceed())
      return true;
    System.out.println("Not found: " + storable + " -> inserting");
    return storable.tryInsert();
  }
}