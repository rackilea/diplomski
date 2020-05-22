package com.acme.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

@Configuration
public class SauceLabsWebDriverConfiguration {

    @Autowired private Environment environment;

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public WebDriver webDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("version", environment.getProperty("SELENIUM_VERSION", "17.0.1"));
        capabilities.setCapability("platform", environment.getProperty("SELENIUM_PLATFORM", "XP"));
        capabilities.setCapability("browserName", environment.getProperty("SELENIUM_BROWSER", "firefox"));
        String username = environment.getProperty("SAUCE_USER_NAME", "enter_your_username_here");
        String accessKey = environment.getProperty("SAUCE_API_KEY", "enter_your_api_here");
        return new RemoteWebDriver(new URL("http://" + username + ":" + accessKey + "@ondemand.saucelabs.com:80/wd/hub"), capabilities);
    }
}