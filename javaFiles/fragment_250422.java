package com.alex.demo.ctx;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfigurationAttributes;
import org.springframework.test.context.ContextCustomizer;
import org.springframework.test.context.ContextCustomizerFactory;
import org.springframework.test.context.MergedContextConfiguration;

public class HierarchyContextCustomizerFactory implements ContextCustomizerFactory {

    @Override
    public ContextCustomizer createContextCustomizer(Class<?> testClass,
            List<ContextConfigurationAttributes> configAttributes) {
        return new ContextCustomizer() {

            @Override
            public void customizeContext(ConfigurableApplicationContext context,
                    MergedContextConfiguration mergedConfig) {
                if (mergedConfig.getParentApplicationContext() != null) {
                    context.setParent(mergedConfig.getParentApplicationContext());
                }

            }

        };
    }

}