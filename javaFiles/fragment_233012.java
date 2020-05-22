import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class DynamicCellRenderer implements ListCellRenderer {
    private final ListCellRenderer listCellRenderer;
    private String displayMember;

    public DynamicCellRenderer(String displayMember) {
        this(displayMember, new DefaultListCellRenderer());
    }

    public DynamicCellRenderer(String displayMember, ListCellRenderer wrapped) {
        listCellRenderer = wrapped;
        this.displayMember = displayMember;
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Object displayMemberValue = getDisplayMemberValue(value);
        return listCellRenderer.getListCellRendererComponent(list, displayMemberValue, index, isSelected, cellHasFocus);
    }

    private Object getDisplayMemberValue(Object value) {
        // value is the domain class
        // only works if display member is a method, TODO: fallback to field
        // displayMember is something like "getName" -> value.getName() gets called
        try {
            return value.getClass().getMethod(displayMember).invoke(value);
        } catch (Exception ex) {
            // if anything went wrong it is the programmers fault -> propagate exception
            throw new RuntimeException(ex);
        }
    }

    public String getDisplayMember() {
        return displayMember;
    }

    public void setDisplayMember(String displayMember) {
        this.displayMember = displayMember;
    }

}