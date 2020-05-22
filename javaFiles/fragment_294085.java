@ControllerAdvice
public class UserControllerAdvice extends AbstractEntityEditorControllerAdvice<UserEditor>{
    public UserControllerAdvice() {
        super(User.class);
    }
}