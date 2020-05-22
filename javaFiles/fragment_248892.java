package practise;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener2;
import org.testng.ITestContext;
import org.testng.ITestResult;

public class InvokedMethodListener implements IInvokedMethodListener2
{
    @Override
    public void afterInvocation(IInvokedMethod arg0, ITestResult arg1)
    {
        System.out.println(Thread.currentThread().getStackTrace()[0].getMethodName());
    }

    @Override
    public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1)
    {
        System.out.println(Thread.currentThread().getStackTrace()[0].getMethodName());
    }

    @Override
    public void afterInvocation(IInvokedMethod arg0, ITestResult arg1, ITestContext arg2)
    {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Override
    public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1, ITestContext arg2)
    {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

}


    package practise;

import java.util.List;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

public class MethodInterceptor implements IMethodInterceptor
{

    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> arg0, ITestContext arg1)
    {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        return arg0;
    }

}

    package practise;

import org.testng.annotations.Listeners;

@Listeners(value={MethodInterceptor.class,InvokedMethodListener.class})
public class Test
{
    @org.testng.annotations.Test
    public void first()
    {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @org.testng.annotations.Test
    public void second()
    {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}