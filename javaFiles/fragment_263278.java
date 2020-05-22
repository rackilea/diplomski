import java.awt.event.ItemEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

public class RadioCombo<T> {
    private JRadioButton radioBtn;
    private JComboBox<T> combo;

    public RadioCombo(String text, DefaultComboBoxModel<T> model) {
        radioBtn = new JRadioButton(text);
        combo = new JComboBox<>(model);
        combo.setEnabled(false);
        radioBtn.addItemListener(evt -> {
            combo.setEnabled(evt.getStateChange() == ItemEvent.SELECTED);
        });
    }

    public JRadioButton getRadioBtn() {
        return radioBtn;
    }

    public JComboBox<T> getCombo() {
        return combo;
    }
}