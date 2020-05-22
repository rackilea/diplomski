package org.openqa.selenium.support.ui;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;

public class WebElementWait  extends FluentWait<WebElement>  {
    public final static long DEFAULT_SLEEP_TIMEOUT = 500;

      public WebElementWait(WebElement element, long timeOutInSeconds) {
            this(element, new SystemClock(), Sleeper.SYSTEM_SLEEPER, timeOutInSeconds, DEFAULT_SLEEP_TIMEOUT);
      }

      public WebElementWait(WebElement element, long timeOutInSeconds, long sleepInMillis) {
            this(element, new SystemClock(), Sleeper.SYSTEM_SLEEPER, timeOutInSeconds, sleepInMillis);
      }

      protected WebElementWait(WebElement element, Clock clock, Sleeper sleeper, long timeOutInSeconds,
              long sleepTimeOut) {
            super(element, clock, sleeper);
            withTimeout(timeOutInSeconds, TimeUnit.SECONDS);
            pollingEvery(sleepTimeOut, TimeUnit.MILLISECONDS);
            ignoring(NotFoundException.class);
      }

}