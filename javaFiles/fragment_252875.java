@Valid
@OneOf(value = {"customerKey", "custmerKey"})
public class HeaderDataDTO extends HeaderValidator {

    private String customerKey;
    private String custmerKey;
//getter and setter