package org.springframework.test.context.junit4.rules;

import org.springframework.test.context.TestContextManager;

public final class SpringClassRuleHack {

   private SpringClassRuleHack() {}

   public static TestContextManager getTestContextManager(Class<?> testClass) {
      return SpringClassRule.getTestContextManager(testClass);
   }

}