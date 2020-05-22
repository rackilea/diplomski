package com.example;
public class AllPagesToOneViewProvider extends HttpConfigurationProvider
{
   @Override
   public int priority()
   {
     return 0;
   }

   @Override
   public Configuration getConfiguration(final ServletContext context)
   {
     return ConfigurationBuilder.begin()
       .addRule(Join.path("/{all}").to("/pages.xhtml"))
       .where("all").matches(".*");
    }
}