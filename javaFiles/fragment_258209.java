package com.example.checkbox;

   import cucumber.api.CucumberOptions;
   import cucumber.api.SnippetType;
   import cucumber.api.junit.Cucumber;
   import org.junit.runner.RunWith;

   @RunWith(Cucumber.class)
   @CucumberOptions(
                snippets = SnippetType.CAMELCASE,
                glue = {"com.example.checkbox"},
                features = "classpath:features/checkbox")
   public class CheckboxTest {

    /*
    * This class should be empty, step definitions should be in separate classes.
    */

   }