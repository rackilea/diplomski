String content = textArea.getText();

    while(content.lastIndexOf(s) >= 0)
    {
        int index = content.lastIndexOf(s);
        int end = index + s.length;

        highLighter.addHighlight(index, end, highlighterPainter);
        textArea.setCaretPosition(end);
        textField.setBackground(entryBgColor);
        labelMessage("'" + s + "' found. Press ESC to end search");

        content = content.substring(0, index - 1);
    }