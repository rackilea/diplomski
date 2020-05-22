package com.aop.agent;

import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.LoaderClassPath;
import javassist.NotFoundException;

public class Agent {

  public static void premain(String agentArgs, Instrumentation instr) {
    System.out.println("Agent starts!");
    instr.addTransformer(new ClassFileTransformer() {

      @Override
      public byte[] transform(ClassLoader classLoader, String className, Class<?> arg2, ProtectionDomain arg3,
          byte[] bytes)
          throws IllegalClassFormatException {
        System.out.println("Before loading class " + className);

        final String TARGET_CLASS = "com/aop/example/LibClass";

        if (!className.equals(TARGET_CLASS)) {
          return null;
        }

        LoaderClassPath path = new LoaderClassPath(classLoader);
        ClassPool pool = new ClassPool();
        pool.appendSystemPath();
        pool.appendClassPath(path);

        try {
          CtClass targetClass = pool.get(TARGET_CLASS.replace('/', '.'));
          System.out.println("Enhancing class " + targetClass.getName());
          CtMethod[] methods = targetClass.getDeclaredMethods();
          for (CtMethod method : methods) {
            if (!method.getName().contains("packagePrivateMethod")) {
              continue;
            }
            System.out.println("Enhancing method " + method.getSignature());
            String myMethodInvocation = "com.aop.agent.Agent.myMethodInvocation();";
            method.insertBefore(myMethodInvocation);
          }
          System.out.println("Enhanced bytecode");

          return targetClass.toBytecode();
        }
        catch (CannotCompileException e) {
          e.printStackTrace();
          throw new RuntimeException(e);
        }
        catch (IOException e) {
          e.printStackTrace();
          throw new RuntimeException(e);
        }
        catch (NotFoundException e) {
          e.printStackTrace();
          throw new RuntimeException(e);
        }
      }

    });
  }

  public static void myMethodInvocation() {
    System.out.println("<<<My injected code>>>!");
  }
}