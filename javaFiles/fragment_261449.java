package com.application.my;

import java.util.Collections;
import java.util.List;

import com.sun.jersey.api.model.AbstractMethod;
import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;
import com.sun.jersey.spi.container.ContainerResponseFilter;
import com.sun.jersey.spi.container.ResourceFilter;
import com.sun.jersey.spi.container.ResourceFilterFactory;

public final class TestFilterFactory implements ResourceFilterFactory {

    @Override
    public List<ResourceFilter> create(final AbstractMethod method) {
        return Collections.<ResourceFilter>singletonList(new ResourceFilter() {
            @Override
            public ContainerRequestFilter getRequestFilter() {
                return new ContainerRequestFilter() {
                    @Override
                    public ContainerRequest filter(final ContainerRequest request) {

                        System.out.println("form: " + request.getFormParameters());

                        return request;
                    }
                };
            }
            @Override
            public ContainerResponseFilter getResponseFilter() {
                return null;
            }
        });
    }
}