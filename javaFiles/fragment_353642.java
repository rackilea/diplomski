input.addActionListener(e -> {
    String text = input.getText().trim();
    if (text.isEmpty()) {
        return;
    }
    output.append(text + "\n");

    input.setText("");
});