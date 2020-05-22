package my.package;

import com.ctc.wstx.stax.WstxOutputFactory;
public class MyWstxOutputFatory extends WstxOutputFactory {

    public MyWstxOutputFatory() {
        setProperty(
                com.ctc.wstx.api.WstxOutputProperties.P_OUTPUT_INVALID_CHAR_HANDLER,
                new com.ctc.wstx.api.InvalidCharHandler.ReplacingHandler(' '));
    }
}