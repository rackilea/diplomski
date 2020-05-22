class FieldFactory {
    static Map<Class<? extends SuperClass>, Class<? extends View>> fieldEditorMap = new HashMap<>();

    static {
        fieldEditorMap.put(SubClass1.class, TextBox.class);
        fieldEditorMap.put(SubClass2.class, CheckBox.class);
    }

    public static View getViewFromPDField(Context context, SuperClass field) {
        Class<? extends View> editorClass = fieldEditorMap.get(field.getClass());
        try {
            return editorClass.getConstructor(Context.class).newInstance(context);
        } catch (Exception e) {
            throw new IllegalArgumentException("Can not create view for " + field.getClass().getSimpleName(), e);
        }
    }
}