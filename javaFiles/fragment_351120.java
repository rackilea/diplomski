public class GsonObjectWraper extends DefaultObjectWrapper {

    public GsonObjectWraper(Version incompatibleImprovements){
                super(incompatibleImprovements);
    }

    @Override
    public TemplateModel wrap(Object obj) throws TemplateModelException {
        if (obj == null) {
            return super.wrap(null);
        }
        if (obj instanceof JsonArray) {
            return handleUnknownType(obj);
        }
        return super.wrap(obj);
    }
}