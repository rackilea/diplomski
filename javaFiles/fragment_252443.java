public static void main(String[] args)
{
    Display display = new Display();
    Shell shell = new Shell(display);
    shell.setText("StackOverflow");
    shell.setLayout(new FillLayout());

    StyledText text = new StyledText(shell, SWT.BORDER | SWT.MULTI | SWT.WRAP);

    text.setText("public class Text\n{\n    public static void main(String[] args)\n    {\n        System.out.println(\"Text\");\n    }\n}");

    String[] lines = text.getText().split("\\n");

    String keyWord = "public";
    Color red = display.getSystemColor(SWT.COLOR_RED);

    int offset = 0;
    for (String line : lines)
    {
        int index = line.indexOf(keyWord);

        if (index != -1)
        {
            StyleRange range = new StyleRange(index + offset, keyWord.length(), red, null, SWT.BOLD);
            text.setStyleRange(range);
        }

        offset += line.length() + 1; // +1 for the newline character
    }

    shell.pack();
    shell.open();
    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
        {
            display.sleep();
        }
    }
    display.dispose();
}