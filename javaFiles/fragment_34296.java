package de.scrum_master.aspect;

import java.util.stream.Stream;

public aspect MyAspect {
  before(): !within(*Aspect) && call(* Stream.*(..)) {
    System.out.println(thisJoinPoint);
    System.out.println("  called by: " + thisEnclosingJoinPointStaticPart);
    System.out.println("  line: " + thisJoinPoint.getSourceLocation().getLine());
  }
}