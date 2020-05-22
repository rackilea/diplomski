package test.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.matcher.Matchers;

public class Log4j2CustomInjection {

  public static void main(String[] args) {
    Injector injector =
        Guice.createInjector(
            new AbstractModule() {
              @Override
              protected void configure() {
                bind(PaymentService.class).asEagerSingleton();
                bindListener(Matchers.any(), new Log4JTypeListener());
              }
            });

    PaymentService ps = injector.getInstance(PaymentService.class);
    ps.logger.info("hello");
  }
}