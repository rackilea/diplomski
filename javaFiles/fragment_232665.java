package org.daimor;

import java.io.FileInputStream;
import java.io.IOException;

public class test {

    public long sizeStream(FileInputStream stream)
    {
        try {
            return stream.getChannel().size();
        } catch (IOException ex)
        {
            return -1;
        }
    }
}