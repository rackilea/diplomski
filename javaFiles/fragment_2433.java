public class Main implements MyInterface{

@Override
public void onSuccess(boolean value){
//TODO do your stuff with returned boolean from your call
}

@Override
public void onException(String value){
//TODO you will receive the message here
}

//in your onCreate
...
//method call
connectPassword("username","password",this);

}