public class ParentController extends AbstractController<Parent> {
    @Override
    protected Class<? extends Parent> getType() {
        return Parent.class;
    }
}

public class SonController extends ParentController {
    @Override
    protected Class<? extends Parent> getType() {
        return Son.class;
    }
}