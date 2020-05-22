package com.question;

import org.apache.cxf.jaxrs.ext.ResponseHandler;
import org.apache.cxf.jaxrs.model.OperationResourceInfo;
import org.apache.cxf.message.Message;


/*
 * Filter for Responses
 */
public class CustomOutfilter implements ResponseHandler
{


    /*
     * @param : arg0
     * 
     * @param : arg1
     * 
     * @param : arg2
     * 
     * @return : Response
     */
    @Override
    public Response handleResponse(Message arg0, OperationResourceInfo arg1,
            Response arg2)
    {
        //play with arg2 here and return it

        return arg2;

    }

}