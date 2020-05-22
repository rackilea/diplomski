private static final int TAB_WIDTH = 5;

public static void main(String[] args)
{
    final Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setText("Stackoverflow");
    shell.setLayout(new FillLayout());

    StyledText text = new StyledText(shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
    text.setTabs(TAB_WIDTH);
    text.setText("");
    text.setLeftMargin(5);
    text.setBounds(0, 0, 512, 391);
    text.addListener(SWT.KeyUp, (e) -> {
        if (e.stateMask == SWT.CTRL && e.keyCode == 'u')
        {
            int currentLine = text.getLineAtOffset(text.getCaretOffset());
            String textAtLine = text.getLine(currentLine);
            int spaces = getLeadingSpaces(textAtLine);
            text.insert("\n");
            text.setCaretOffset(text.getCaretOffset() + 1);
            for (int i = 0; i < spaces; i++)
                text.append(" ");

            text.setCaretOffset(text.getCaretOffset() + spaces);
        }
    });

    shell.pack();
    shell.open();
    shell.setSize(400, 300);

    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}

private static int getLeadingSpaces(String line)
{
    int counter = 0;

    char[] chars = line.toCharArray();
    for (char c : chars)
    {
        if (c == '\t')
            counter += TAB_WIDTH;
        else if (c == ' ')
            counter++;
        else
            break;
    }

    return counter;
}