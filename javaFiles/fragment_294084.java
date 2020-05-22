@Component
public class UserEditor extends AbstractEntityEditor<ObjectId, UserService> {
    public UserEditor() {
        super(ObjectId.class);
    }
}