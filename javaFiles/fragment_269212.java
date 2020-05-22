public class UserDTO {
    private String name;
    private Character status;

    public UserDTO(String name, String status){
        this.name = name;
        this.status = status.charAt(0);
    }
}