package combobox;

import java.awt.Component;
import java.awt.event.ActionListener;
import javax.swing.ComboBoxEditor;
import javax.swing.JTextField;

public class MyComboEditor implements ComboBoxEditor {
  JTextField textFeild;
  Object myObject[];
  Object myReturnObject;

public MyComboEditor(){
    textFeild = new JTextField();     
}

@Override
public Component getEditorComponent() {
    return textFeild;
}

@Override
public void setItem(Object anObject) {

    if(anObject != null){
        myObject = (Object[])anObject;
        myReturnObject = anObject;            
        textFeild.setText(myObject[1].toString());
     }
     else{ 
       myReturnObject = anObject;
     }
}

@Override
public Object getItem() {
    String objectTxt = myObject[1].toString();
    String feildTxt = textFeild.getText();

    if(objectTxt.equals(feildTxt)){
        return myReturnObject;
    }
    else{
        return new Object[]{"0",textFeild.getText()};
    }
}

@Override
public void selectAll() {
    throw new UnsupportedOperationException(
            "Not supported yet. in select All");
}

@Override
public void addActionListener(ActionListener l) {
    textFeild.addActionListener(l);     
}

@Override
public void removeActionListener(ActionListener l) {
    textFeild.removeActionListener(l);
}    
}