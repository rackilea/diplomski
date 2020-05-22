package framework.matlab.events;

import matlabcontrol.MatlabConnectionException;
import matlabcontrol.MatlabInvocationException;
import matlabcontrol.MatlabProxy;
import matlabcontrol.MatlabProxyFactory;
import matlabcontrol.MatlabProxyFactoryOptions;

public class MatlabEvent {  

    private String      mMethodName;
    private int         mMethodOutputs;
    private MatlabProxy mProxy;

    public void setMethodParameters(String iMethodName, int iMethodOuputs) {
        mMethodName     = iMethodName;
        mMethodOutputs  = iMethodOuputs;        
    }

    public void callMatlabMethod(Object ... obj) {

        connect();

        try {
            mProxy.returningFeval(mMethodName, mMethodOutputs, obj);    
        } catch (MatlabInvocationException e) {
            e.printStackTrace();
        }
        finally   {
            disconnect();
        }   
    }

    private void connect() {

        MatlabProxyFactoryOptions options = new MatlabProxyFactoryOptions.Builder()
                .setUsePreviouslyControlledSession(true)
                .build();

        MatlabProxyFactory factory  = new MatlabProxyFactory(options);      

        try {
            mProxy = factory.getProxy();
        } catch (MatlabConnectionException e) {
            e.printStackTrace();
        }

    }

    private void disconnect() {
        if (null != mProxy) {
            mProxy.disconnect();
        }
    }
}