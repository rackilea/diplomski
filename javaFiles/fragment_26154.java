package com.amazonaws.lambda.demo;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class LambdaFunctionHandler implements RequestHandler<RequestClass, ResponseClass> {

    public ResponseClass handleRequest(RequestClass input, Context context) {
        context.getLogger().log("Input: " + input);

        // TODO: implement your handler
        ResponseClass myVal = new ResponseClass();
        myVal.setGreetings("Hello from POJO - " + input.getName() );
        return myVal;
    }

}