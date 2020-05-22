for (int i = 0; i < ops.length; i++) {
    if (text.endsWith(ops[i])) {
        field.setText("");
        System.out.println("called");
        break;
    }
}

/* Checks if number was pressed */
for (int i = 0; i <= 9; i++) {
    if (e.getSource() == buttons[i]) {
        // Here, the field text is been rest to text + button.text...
        field.setText(text + buttons[i].getText());
        // And nothing will be executed after it...
        return;
    }
}