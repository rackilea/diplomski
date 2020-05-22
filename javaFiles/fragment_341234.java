package de.mit.stackoverflow;

import java.io.IOException;
import java.io.OutputStream;

public class LogOutputStream extends OutputStream {

    private StringBuilder sb = new StringBuilder();

    @Override
    public void write(int b) throws IOException {
        if (b == '\n') {
            log(sb.toString());
            sb.setLength(0);
        } else {
            sb.append((char) b);
        }
    }

}