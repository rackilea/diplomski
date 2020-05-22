public class  RSAService {
    protected void doRSA(){}
}

class MyService extends RSAService{
    public void myService(){
        super.doRSA(); //Works fine
    }
}