import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

public class Main {
        JComboBox<String> shapeChoice = new JComboBox<>();
        shapeChoice.addItem("Point");
        shapeChoice.addItem("Square");
        shapeChoice.addItem("Circle");
        shapeChoice.addItem("Doughnut");
        shapeChoice.addItem("Pentagon");
        shapeChoice.addItem("Hexagon");
        System.out.println(combo2Array(shapeChoice).toString());
    }
    public static List<String> combo2Array(JComboBox<String> combo){

        List<String> list = new ArrayList<>();
        for(int i=0;i<combo.getItemCount();i++){
            list.add(combo.getItemAt(i));
        }
        return list;
    }
}