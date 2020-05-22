package example;

import java.io.IOException;
import java.io.OutputStream;

public class RedirectingOutputStream extends OutputStream {

    private GUI gui;

    public RedirectingOutputStream(GUI gui) {
        this.gui = gui;
    }

    @Override
    public void write(int b) throws IOException {
        gui.appendText(String.valueOf((char) b));
    }
}