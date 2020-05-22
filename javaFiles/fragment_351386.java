package info.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.statements.RunBefores;
import org.junit.runner.RunWith;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4AnnotationsSequenceTest.CustomSpringJUnit4ClassRunner.class)
public class JUnit4AnnotationsSequenceTest
{
  private String value = null;

  @Before
  public void setUp()
  {
    value = "@Before.setUp";
  }

  @RightBeforeTest
  public void latestChance()
  {
    value = "@RightBeforeTest.latestChance"; 
  }

  @Test
  public void rightBeforeTestAnnotationExecutesAfterBeforeAnnotation()
  {
    assertEquals("@RightBeforeTest.latestChance", value);
  }

  public static class CustomSpringJUnit4ClassRunner extends SpringJUnit4ClassRunner
  {
    public CustomSpringJUnit4ClassRunner(final Class<?> clazz) throws InitializationError
    {
      super(clazz);
    }

    protected Statement methodInvoker(final FrameworkMethod method, final Object test)
    {
      return new RunBefores(
          super.methodInvoker(method, test),
          getTestClass().getAnnotatedMethods(RightBeforeTest.class),
          test);
    }
  }

  @Retention(RetentionPolicy.RUNTIME) @Target(ElementType.METHOD)
  public @interface RightBeforeTest {}
}