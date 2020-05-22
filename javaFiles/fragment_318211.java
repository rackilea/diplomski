import java.awt.*;
import javax.swing.table.*;

public class Main
{
    public static void main(String[] args)
    {
        TableColumn tc = new TableColumn();
        tc.setMinWidth(1);
        tc.setMaxWidth(10);
        tc.setPreferredWidth(15);
        System.out.println( tc.getPreferredWidth() );
    }
}