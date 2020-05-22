public static void main(String[] args)
{
    Display display = Display.getDefault();
    final Shell shell = new Shell(display);
    shell.setText("StackOverflow");
    shell.setLayout(new GridLayout(2, false));

    Text text = new Text(shell, SWT.BORDER);
    GridData data = new GridData(SWT.FILL, SWT.BEGINNING, true, true);
    data.horizontalSpan = 2;
    text.setLayoutData(data);
    new Label(shell, SWT.NONE).setText("Current word:");
    final Label label = new Label(shell, SWT.NONE);

    text.addListener(SWT.Verify, new Listener()
    {
        @Override
        public void handleEvent(Event e)
        {
            Text source = (Text) e.widget;

            /* Construct the entered text */
            String oldString = source.getText();
            String textString = oldString.substring(0, e.start) + e.text + oldString.substring(e.end);

            /* Get all the chars */
            char[] text = textString.toCharArray();

            /* Get the cursor position */
            int position = source.getCaretPosition();

            /* Adjust cursor position based on input (necessary for delete operations) */
            if(e.text.equals(""))
                position--;
            else
                position++;

            /* Remember start and end of current word */
            int leftBorder = -1;
            int rightBorder = -1;

            /* Search for left end of the current word */
            for(int i = 1; i < position; i++)
            {
                int left = position - i;

                if(left > 0)
                {
                    if(!Character.isLetter(text[left]))
                    {
                        leftBorder = left + 1;
                        break;
                    }
                }
            }

            /* Search for right end of the current word */
            for(int i = position; i < text.length; i++)
            {
                int right = i;

                if(right < text.length)
                {
                    if(!Character.isLetter(text[right]))
                    {
                        rightBorder = right;
                        break;
                    }
                }
            }

            /* If the word is the first/last, set border accordingly */
            if(leftBorder == -1)
                leftBorder = 0;
            if(rightBorder == -1)
                rightBorder = text.length;

            StringBuilder result = new StringBuilder();
            /* Output the word */
            for(int i = leftBorder; i < rightBorder; i++)
                result.append(text[i]);

            label.setText(result.toString());
            shell.layout(true, true);
        }
    });

    shell.pack();
    shell.setSize(600, 100);
    shell.open();
    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}