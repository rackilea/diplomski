import java.io.*; //For printwriter.
import java.util.*; //for scanner.
import javax.swing.*; //for JOption Pane.
public class dates {
    public static void main(String[] args) throws IOException {
        //Ask user for birthday variables. 
        String userMonth; 
        userMonth = JOptionPane.showInputDialog("Please enter your birthday month ex: January"); 
        String userDay; 
        userDay = JOptionPane.showInputDialog("Please enter your birthday day, ex: 5, or 24."); 
        Eventday(userMonth,userDay);
        System.exit(0);
    }

    private static void Eventday(String userMonth, String userDay) throws  IOException{

        File file = new File("famous dates.txt");
        if(!file.exists())return;
        Scanner s = new Scanner(file);
        ArrayList<String> list = new ArrayList<String>();
        while(s.hasNext()) {
            list.add(s.nextLine());
        }
        s.close();

        for(String event : list) {
            String[] data = event.split(", ");
            if(data[0].equalsIgnoreCase(userMonth) && data[1].equalsIgnoreCase(userDay))
                System.out.println(data[2]);
        }
    }
}