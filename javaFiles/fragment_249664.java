public abstract class Payload {

     private long createTimestamp;
     private String key;
     // some other fields are here
     // getters and setters here
}

public class PayloadA extends Payload  {
    //add existing code
}
public class PayloadB extends Payload {
    //add existing code
}

private void process(Payload payload) {

     //Depending upon the object passed, fields will be set for A or B       

     payload.setCreateTimestamp(ADD_DATA1);
     payload.setKey(ADD_DATA2);
     //set other fields

    //if(payload instanceof PayloadA) {
        //payloadA
    //}
}