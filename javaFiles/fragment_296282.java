public interface CheckItFirst {}

public interface ThenCheckIt {}

public class FormModel {

    @NotBlank
    private String name;

    @NotNull(groups = CheckItFirst.class)
    @ImageSizeConstraint(groups = ThenCheckIt.class)
    private MultipartFile image;
}