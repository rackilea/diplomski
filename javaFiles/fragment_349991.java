public class Message implements Serializable{
     private Long id;
     private String msgText;
     //other necessary properties

     public Message(){
        this(0, "default message");
     }

     public Message(Long id, String msgText){
         setId(id);
         setMsgText(msgText);
         //etc
     }

     //getters and setters
}