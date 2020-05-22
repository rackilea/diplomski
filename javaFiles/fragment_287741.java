package p1;

import java.lang.annotation.*;
import java.lang.reflect.*;

public class A {
  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.FIELD)
  public @interface DetailsField  {
     public int n1();   
     public String name() default "";     
  }

  public static class Nameable implements DetailsField {
     private final DetailsField df;
     private final Field f;

     public Nameable(Field f) {
        this.f = f;
        this.df = f.getAnnotation(DetailsField.class);
     }

     @Override
     public Class<? extends Annotation> annotationType() {
        return df.annotationType();
     }

     @Override
     public String toString() {
        return df.toString();
     }

     @Override
     public int n1() {
        return df.n1();
     }

     public String name() {
        return f.getName();
     }   
  }

  public class B {
     @DetailsField(n1=3)
     public int someField;
  }

  public static void main(String[] args) throws Exception {
     Field f = B.class.getField("someField");

     Nameable n = new Nameable(f);
     System.out.println(n.name()); // output: "someField"
     System.out.println(n.n1());   // output: "3"
  }
}