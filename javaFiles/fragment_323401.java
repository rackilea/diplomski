public abstract class  RSAService {
    protected void doRSA(){}
}

class MyService extends RSAService{
    public void myService(){
    }

    @Override
    protected void doRSA() {
        super.doRSA();
    }
}