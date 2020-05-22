try {
    name = jTextFieldName.getText();
    admin = Integer.parseInt(jTextFieldAdmin.getText());
    anal = Integer.parseInt(jTextFieldAnalytical.getText());
    creat = Integer.parseInt(jTextFieldCreative.getText());
    finish = Integer.parseInt(jTextFieldFinisher.getText());

    persons.addPerson(name, admin, anal, creat, finish);

    persons.savePersons();
} catch (NumberFormatException e) {
    // One of the integer fields failed to parse. Do something to alert the user.
}