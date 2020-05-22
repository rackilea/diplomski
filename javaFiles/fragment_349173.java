import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import java.util.Vector;

public class Class implements PropertyChangeListener{
    private JRadioButtonExample b;

    public Class(JRadioButtonExample b){
        this.b = b;
        b.addPropertyChangeListener(this);
    }

    public static void main(String[] args){
        ArrayList<String> a = new ArrayList<String>();
        a.add("hi");
        a.add("all");
        JRadioButtonExample myButton = new JRadioButtonExample(2,a);
        Class myClass = new Class(myButton);         
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Vector<Boolean> boo = b.getCheck();
         for(Boolean bool : boo){
               System.out.println(bool);
         }      
    }
}