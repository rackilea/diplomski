package com.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.MethodMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;
import org.springframework.stereotype.Component;

@Component
public class DoSomethingPostprocessor implements BeanFactoryPostProcessor, ApplicationContextAware {

    private ApplicationContext applicationContext;

    private Object createDoSomethingBean(final MethodMetadata mmd, final Map<String, Object> attributes)
            throws Exception {
        final String pattern = (String) attributes.get("pattern");
        final Class<?> clazz = Class.forName(mmd.getDeclaringClassName());
        return Proxy.newProxyInstance(clazz.getClassLoader(), new Class[] { clazz },
                new InvocationHandler() {

                    @Override
                    public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {
                        System.out.println(String.format(pattern, args[0]));

                        return null;
                    }
                });
    }

    @Override
    public void postProcessBeanFactory(final ConfigurableListableBeanFactory beanFactory) throws BeansException {
        try {
            final String packageSearchPath = "classpath*:com/**/*.class";

            final Resource[] resources =
                    applicationContext.getResources(packageSearchPath);
            final SimpleMetadataReaderFactory factory = new
                    SimpleMetadataReaderFactory(applicationContext);

            for (final Resource resource : resources) {
                final MetadataReader mdReader = factory.getMetadataReader(resource);

                final AnnotationMetadata am = mdReader.getAnnotationMetadata();
                final Set<MethodMetadata> methodMetadata =
                        am.getAnnotatedMethods(DoSomething.class.getName());
                for (final MethodMetadata mmd : methodMetadata) {
                    final Map<String, Object> attributes =
                            mmd.getAnnotationAttributes(DoSomething.class.getName());
                    final String beanName = mmd.getDeclaringClassName();
                    beanFactory.registerSingleton(beanName, createDoSomethingBean(mmd, attributes));
                }
            }
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}