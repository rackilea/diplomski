import javax.swing.SwingUtilities;

import com.ggl.text.entry.model.TextEntryModel;
import com.ggl.text.entry.view.TextEntryFrame;

public class TextEntry implements Runnable {

    @Override
    public void run() {
        new TextEntryFrame(new TextEntryModel());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new TextEntry());
    }

}