public void setAsError(JComponent component){
    if(component instanceof JTextField){
    JTextField field =  (JTextField) component;
    field.setBackground(Color.RED);
    }else if(component instance of JTextArea){
    JTextArea area = (JTextArea) component;
    area.setBackground(Color.RED);
    }
}