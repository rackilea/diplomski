public abstract class AbstractEntityEditorControllerAdvice<EDITOR extends PropertyEditor> {

    @Autowired
    EDITOR editor;

    final Class<?> entity;

    public AbstractEntityEditorControllerAdvice(Class<?> entity) {
        this.entity = entity;
    }

    @InitBinder
    public void register(WebDataBinder binder, WebRequest request) {
        binder.registerCustomEditor(entity, editor);
    }

}