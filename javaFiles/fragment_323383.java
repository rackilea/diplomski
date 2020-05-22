convert(f.getType(),f.getText());


import java.beans.PropertyEditor;
import java.beans.PropertyEditorManager;

private Object convert(Class<?> targetType, String text) {
    PropertyEditor editor = PropertyEditorManager.findEditor(targetType);
    editor.setAsText(text);
    return editor.getValue();
}