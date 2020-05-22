package com.test.testng;

import java.util.Arrays;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;

public class Listener implements IInvokedMethodListener {

    public void afterInvocation(IInvokedMethod method, ITestResult itr) {
        // TODO implements
    }

    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {

        // Parameters value
        System.out.println("Parameters invocation value for method " + method.getTestMethod().getMethodName());
        Arrays.asList(testResult.getParameters()).stream().forEach(System.out::println);

        // get data-id
        for (XmlClass test : testResult.getTestContext().getCurrentXmlTest().getXmlClasses()) {
            for (XmlInclude met : test.getIncludedMethods()) {

                if (met.getName().equals(method.getTestMethod().getMethodName())) {
                    int key = Integer.parseInt(met.getAllParameters().get("data-id"));
                    System.out.println("listener: Running method " + method.getTestMethod().getMethodName() + "  with data-id: " + key);
                }        
            }
        }
    }
}