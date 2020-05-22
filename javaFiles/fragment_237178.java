package numerictextfield;

import java.util.regex.Pattern;

import javafx.scene.control.IndexRange;
import javafx.scene.control.TextField;

public class NumericTextField extends TextField {

    private final Pattern intPattern = Pattern.compile("[0-9]*");

    public NumericTextField(String text) {
        super(text);
    }
    public NumericTextField() {
        super();
        this.insertText(0, "");
        this.replaceSelection("");
        this.replaceText(new IndexRange(0, 0), "");
        this.replaceText(0, 0, "");
    }

    @Override
    public void insertText(int index, String text) {
        if (intPattern.matcher(text).matches()) {
            super.insertText(0, text);
        }
    }

    @Override
    public void replaceSelection(String text) {
        if (intPattern.matcher(text).matches()) {
            super.replaceSelection(text);
        }
    }

    @Override
    public void replaceText(IndexRange range, String text) {
        if (intPattern.matcher(text).matches()) {
            super.replaceText(range, text);
        }
    }

    @Override
    public void replaceText(int start, int end, String text) {
        if (intPattern.matcher(text).matches()) {
            super.replaceText(start, end, text);
        }
    }

}