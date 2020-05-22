package com.lethal.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.lethal.model.ServiceType;
import com.lethal.service.ServiceTypeService;

public final class StringToServiceTypeConverter implements Converter<String, ServiceType> 
{

    @Autowired
    private ServiceTypeService ServiceTypeService;       

    @Override
    public ServiceType convert(String id) 
    {

        try
        {
            /**
            * i try to get the object from the given ID
            */

            Integer.parseInt(id);

            ServiceType servizi_tipologia = ServiceTypeService.getServiceType(Integer.valueOf(id));

            return servizi_tipologia;
        }
        catch(NumberFormatException e)
        {
            System.out.println(e);

            return null;
        }       

    }
}