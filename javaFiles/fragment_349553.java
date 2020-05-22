// MyWidget.java
public interface MyWidget {
     Object getValue();
}

// TextWidget.java
public class TextWidget extends JTextField implements MyWidget {
     // (add constructors here)
     public void setValue(Object value) { setText(value.toString()); }
     public Object getValue() { return getText(); }
}

// ComboWidget.java
public class ComboWidget extends JComboBox implements MyWidget {
     // (add constructors here)
     public void setValue(Object value) { setSelectedItem(value); }
     public Object getValue() { return getSelectedItem(); }
}