Action action = new Action("File|New Project", null);
    action.perform();
    WizardOperator wo = new WizardOperator("New Project");
    wo.next();

    JTextFieldOperator txtName = new JTextFieldOperator(
            (JTextField) new JLabelOperator(wo, "Project Name:").getLabelFor());
    txtName.clearText();
    txtName.typeText("MyProject");
    wo.finish();