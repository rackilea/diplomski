public class ResponseClass {

private Status status;

/**
 * If no error found use this method for response
 * 
 * @param message
 * @param data
 * @return
 */
public static ResponseEntity<ResponseClass> ok(Object data) {
    ResponseClass response = new ResponseClass();
    response.getStatus.setMessage.setCode("ok");
    response.getStatus.setMessage("success")

    return ResponseEntity.ok().body(response);
} }

public class Status {
private String message;
private String code;
//Getter Setter
}