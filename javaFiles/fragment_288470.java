import javax.swing.*;

public class TemplatesList extends JComboBox<String>
{

    public TemplatesList()
    {
        setEditable(false);
        addItem("change request");
        addItem("Emergancy Change request");
        addItem("problem request");
        addItem("problem handover");

    }
}