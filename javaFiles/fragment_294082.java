public abstract class AbstractEntityEditor<ID extends Serializable, SERVICE extends CanGetEntityById<?, ID>> extends PropertyEditorSupport {

    @Autowired
    SERVICE service;

    @Autowired
    ConversionService cs;

    final Class<ID> id;

    public AbstractEntityEditor(Class<ID> id) {
        this.id = id;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(service.getById(cs.convert(text, id)));
    }

}