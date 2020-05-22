package com.stackoverflow.springbug.beanfactorydependencyissue;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

public final class Contexts
{
    private static Supplier<ApplicationContext> bootstrap = Suppliers.memoize(new Supplier<ApplicationContext>(){
        public ApplicationContext get()
        {
            return new ClassPathXmlApplicationContext("/bootstrapContext.xml");
        }
    });

    /**
    * Context for beans that are needed before initializing of other beans.
    */
    public static ApplicationContext bootstrap()
    {
        return bootstrap.get();
    }

    private static Supplier<ApplicationContext> applicationContext = Suppliers.memoize(new Supplier<ApplicationContext>(){
        public ApplicationContext get()
        {
            return new ClassPathXmlApplicationContext(new String[]{"/applicationContext.xml"}, bootstrap());
        }
    });

    public static ApplicationContext applicationContext()
    {
        return applicationContext.get();
    }
}