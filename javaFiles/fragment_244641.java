@Named @ViewScoped
public class SurveyController {
    @Inject @Param(name = "id")
    private ParamValue<Long> idParam;

    public void doStuff() {
        if (idParam.getValue().equals(1)) {
            throw new IllegalAccessException("you don't dare");
        }
    }
}