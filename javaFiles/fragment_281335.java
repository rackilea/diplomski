package com.mycompany;

import com.sun.jersey.api.model.AbstractMethod;
import com.sun.jersey.api.model.AbstractResource;
import com.sun.jersey.api.model.AbstractResourceMethod;
import com.sun.jersey.api.model.Parameter;
import com.sun.jersey.server.wadl.WadlGenerator;
import com.sun.research.ws.wadl.Application;
import com.sun.research.ws.wadl.Method;
import com.sun.research.ws.wadl.ObjectFactory;
import com.sun.research.ws.wadl.Option;
import com.sun.research.ws.wadl.Param;
import com.sun.research.ws.wadl.RepresentationType;
import com.sun.research.ws.wadl.Request;
import com.sun.research.ws.wadl.Resource;
import com.sun.research.ws.wadl.Resources;
import com.sun.research.ws.wadl.Response;

import javax.ws.rs.core.MediaType;

public class OptionsWadlGenerator implements WadlGenerator {

    private WadlGenerator _delegate;

    private ObjectFactory objectFactory = new ObjectFactory();

    @Override
    public Param createParam(AbstractResource r, AbstractMethod m, Parameter p) {
        Param param = _delegate.createParam(r, m, p);
        if(((Parameter)p).getParameterClass().isEnum()){
            Object[] values = p.getParameterClass().getEnumConstants();
            for(Object enumItem:values){
                Option option = objectFactory.createOption();
                option.setValue(((Enum)enumItem).name());
                param.getOption().add(option);
            }
        }
        return param;
    }

    @Override
    public void setWadlGeneratorDelegate(WadlGenerator delegate) {
        this._delegate = delegate;
    }

    @Override
    public Application createApplication() {
        return _delegate.createApplication();
    }

    ... all other methods also simply call the _delegate equivalent method    
}