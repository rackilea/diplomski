public abstract class  RSAService {
    protected abstract void doRSA();
}

class MyServe extends RSAService{
    public void myService(){
        super.doRSA(); //This won't work
    }

    @Override
    protected void doRSA() {
    }
}