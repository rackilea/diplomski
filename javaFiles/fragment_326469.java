package de.scrum_master.app;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;

public class Application {
  class Inner {
    public Inner(@NotNull String text) {
      System.out.println("Constructing inner with " + text);
    }
  }

  public static void main(String[] args) throws NoSuchMethodException, SecurityException {
      Constructor<Inner> constructor = Inner.class.getConstructor(Application.class, String.class);
      System.out.println(constructor);
      for (Parameter parameter : constructor.getParameters()) {
        System.out.println("  " + parameter);
        for (Annotation annotation : parameter.getAnnotations())
          System.out.println("    " + annotation);
      }
  }
}