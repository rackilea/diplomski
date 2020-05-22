public class SuperController extends Controller {

    @After/Before/Whatever
    public static void doSomething() {
        String actionMethod = request.actionMethod;
        Class<? extends play.db.Model> model = getControllerAnnotation(CRUD.For.class).value();

        List<String> allowedActions = new ArrayList<String>();
        allowedActions.add("show");
        allowedActions.add("list");
        allowedActions.add("blank");

        if (allowedActions.contains(actionMethod)) {
            List<SuperClass> list = play.db.jpa.JPQL.instance.find(model.getSimpleName()).fetch();
        }
    }
}