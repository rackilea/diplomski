public class GeneralFormFactory implements Supplier<GeneralForm> {

    private final HttpServletRequest request;

    @Inject
    public GeneralFormFactory(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public GeneralForm get() {
        GeneralForm result = new GeneralForm();
        return result;
    }
}