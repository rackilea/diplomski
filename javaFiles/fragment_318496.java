public void Arabe(JTextField txt) {
    txt.getInputContext().selectInputMethod(new Locale("ar", "SA"));
    txt.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);    
}

public void Français(JTextField txt) {
    txt.getInputContext().selectInputMethod(new Locale("fr","FR"));
    txt.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);    
}

private void txt1_FocusGained(java.awt.event.FocusEvent evt) {                                     
    Arabe(my_textfields1);
}                                    

private void txt2_FocusGained(java.awt.event.FocusEvent evt) {                                        
    Français(mytextfields2);
}