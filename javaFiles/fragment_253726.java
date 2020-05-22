package com.example;

import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.CompositePropertySource;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

@Order(Ordered.HIGHEST_PRECEDENCE)
public class ConfigServicePropertyDeprioritizer
        implements ApplicationListener<ApplicationPreparedEvent>
{
    private static final String CONFIG_SOURCE = "bootstrap";

    private static final String PRIORITY_SOURCE = "systemEnvironment";

    @Override
    public void onApplicationEvent(ApplicationPreparedEvent event)
    {
        ConfigurableEnvironment environment = event.getApplicationContext()
                .getEnvironment();
        MutablePropertySources sources = environment.getPropertySources();
        PropertySource<?> bootstrap = findSourceToMove(sources);

        if (bootstrap != null)
        {
            sources.addAfter(PRIORITY_SOURCE, bootstrap);
        }
    }

    private PropertySource<?> findSourceToMove(MutablePropertySources sources)
    {
        boolean foundPrioritySource = false;

        for (PropertySource<?> source : sources)
        {
            if (PRIORITY_SOURCE.equals(source.getName()))
            {
                foundPrioritySource = true;
                continue;
            }

            if (CONFIG_SOURCE.equals(source.getName()))
            {
                // during bootstrapping, the "bootstrap" PropertySource
                // is a simple MapPropertySource, which we don't want to
                // use, as it's eventually removed. The real values will 
                // be in a CompositePropertySource
                if (source instanceof CompositePropertySource)
                {
                    return foundPrioritySource ? null : source;
                }
            }
        }

        return null;
    }
}