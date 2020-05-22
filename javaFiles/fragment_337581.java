package com.stackoverflow.springbug.beanfactorydependencyissue.other;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.stackoverflow.springbug.beanfactorydependencyissue.Contexts;
import com.stackoverflow.springbug.beanfactorydependencyissue.bootstrap.DependantBean;

@Configuration
public class BeanFactoryPostProcessorConfiguration
{

    /**
    * The {@link DependantBean} here caused the bug, {@link Contexts#bootstrap()} is used as a
    * workaround.
    */
    @Bean
    public static BeanFactoryPostProcessor beanFactoryPostProcessor()
    {
        final DependantBean dependantBean = Contexts.bootstrap().getBean(DependantBean.class);
        System.out.println(dependantBean.getDependencyBean());
        return new BeanFactoryPostProcessor(){
            public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException
            {

            }
        };
    }
}