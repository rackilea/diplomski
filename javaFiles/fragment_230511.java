package org.example.beans;

@Component
class Foo { ... }

@Component
class SpringApplicationContext implements ApplicationContextAware {
  private static ApplicationContext CONTEXT;

  @Override
  public void setApplicationContext(final ApplicationContext context) throws BeansException
    CONTEXT = context;
  }

  public static <T> T getBean(String className) {
    return CONTEXT.getBean(Class.forName(className));
  }
}