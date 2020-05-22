public class PayloadService extends Service {   

private static final AtomicReference<PayloadDTO> payload 
          = new AtomicReference<PayloadDTO>(new PayloadDTO());

public static void setPayload(PayloadDTO payload){
    PayloadService.payload.set(payload);
}

public static PayloadDTO getPayload() {
    return PayloadService.payload.get ;
}