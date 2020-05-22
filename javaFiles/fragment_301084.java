public class PayloadHolder {

  private static AtomicReference<PayloadHolder> holder = new AtomicReference<PayloadHolder();    

  //This should be fetched through the holder instance, so no static
  private AtomicReference<PayloadDTO> payload = new AtomicReference<PayloadDTO>();

  private PayloadHolder(){        
  }

  public static PayloadHolder getInstance(){
    PayloadHolder instance = holder.get();

    //Check if there's already an instance
    if(instance == null){

      //Try to set a new PayloadHolder - if no one set it already.
      holder.compareAndSet(null, new PayloadHolder());
      instance = holder.get();

    }
    return instance;
  }

  public void initPayload(){      
    payload.set(new PayloadDTO());

    //Alternative to prevent a second init:
    //payload.compareAndSet(null, new PayloadDTO());
  }

  public PayloadDTO getPayload() {
    return payload.get;
  }

  public void setPayload(PayloadDTO p) {
    payload.set(p);
  }

}

public class PayloadService extends Service {   

  private final PayloadHolder payloadHolder = PayloadHolder.getInstance();

  public void initPayload(){        
    payloadHolder.initPayload();        
  }

  public void setPayload(PayloadDTO payload){       
    payloadHolder.setPayload(payload);      
  }

  public PayloadDTO getPayload() {      
    return payloadHolder.getPayload();      
  }
}