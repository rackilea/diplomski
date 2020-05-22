@Data // Lombok
public class DTO {
    private String name;
    private String phone;
    private String shipping;

    DTO() { }

    DTO(String name, String phone, String shipping) {
        this.name = name;
        this.phone = phone;
        this.shipping = shipping;
    }

    // getter/setters ommitted because of @Data
}