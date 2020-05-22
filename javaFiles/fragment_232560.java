public class GetCustomerByIdPwdResponse implements KvmSerializable {
    GetCustomerByIdPwdResult getCustomerByIdPwdResult;

        @Override
        public Object getProperty(int arg0) {
            if(arg0==0){
                return getCustomerByIdPwdResult;
            }
            return null;
        }

        @Override
        public int getPropertyCount() {
            return 1;
        }

        @Override
        public void getPropertyInfo(int arg0, Hashtable arg1, PropertyInfo arg2) {
            if(arg0==0){
                arg2.name="GetCustomerByIdPwdResult";
                arg2.type=GetCustomerByIdPwdResult.class;
            }
        }

        @Override
        public void setProperty(int arg0, Object arg1) {
            if(arg0==0){
                getCustomerByIdPwdResult=(GetCustomerByIdPwdResult)arg1;
            }
        }
}

public class GetCustomerByIdPwdResult implements KvmSerializable {
    SoapObject Customer; //here goes Customer class ofcourse
    String ErrorMessage;
    String SessionId;

    @Override
    public Object getProperty(int arg0) {
        switch(arg0){
        case 0: return Customer;
        case 1: return ErrorMessage;
        case 2: return SessionId;
        }
        return null;
    }

    @Override
    public int getPropertyCount() {
        return 3;
    }

    @Override
    public void getPropertyInfo(int arg0, Hashtable arg1, PropertyInfo arg2) {
        switch(arg0){
        case 0: arg2.name="Customer"; arg2.type=SoapObject.class;break; //Customer class
        case 1: arg2.name="ErrorMessage"; arg2.type=PropertyInfo.STRING_CLASS;break;
        case 2: arg2.name="SessionId"; arg2.type=PropertyInfo.STRING_CLASS;break;
        }
    }

    @Override
    public void setProperty(int arg0, Object arg1) {
        switch(arg0){
        case 0: Customer=(SoapObject)arg1;break;//Customer class
        case 1: ErrorMessage=(String)arg1;break;
        case 2: SessionId=(String)arg1;break;
        }
    }
}