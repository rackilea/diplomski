for (JTextField textField : findTextFields()) {
    String name = textField.getName();
    Matcher matcher = POSTFIX_PATTERN.matcher(name);
    if (matcher.matches()) {
        String strPostfix = matcher.group(1);
        int postfixNumeric = Integer.parseInt(strPostfix);

        System.out.println("for postfix = " + postfixNumeric + ": " + textField.getText());
    }
}