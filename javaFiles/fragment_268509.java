if (!text.equals(context.getVariable("lastValue"))) {
    ((JTextField)formEnvironment.getFormComponentById("2060")
       .getConfigurationObject()).setText(text);
    context.setVariable("lastValue", text);
} 
return true;