@Security.Authenticated(PlayAuthenticatedSecured.class)
public class StudentController extends Controller {

    private static final Form<Student> studentForm = Form.form(Student.class);

    private static List<Address> addresses;

    @Transactional
    public static Result gravar() throws IOException {
        Form<Student> form = studentForm.bindFromRequest();

       //Hidden Codes

        Student student = form.get();

        student.getAddresses().addAll(addresses);

        student.save();

        flash("success", Messages.get("msg.success2"));
        return redirect(routes.StudentController.lista());
    }

    public static Result createAddress() {
        addresses = new ArrayList<Address>(3);
        JsonNode json = request().body().asJson();
        for (Iterator<JsonNode> item = json.iterator(); item.hasNext();) {
            Address address = Json.fromJson(item.next(), Address.class);
            addresses.add(address);
        }                   
        return ok();
    }

    public static Result jsRoutes() {
        response().setContentType("text/javascript");
        return ok(Routes.javascriptRouter("appRoutes",
                routes.javascript.StudentController.createAddress()
                ));
    }

    //Other methods

}