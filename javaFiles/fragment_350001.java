import javax.swing.*;
    import javax.swing.table.*;
    import java.awt.*;

    class MyTableCellRender extends DefaultTableCellRenderer {

    public MyTableCellRender() {
    setOpaque(true);
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

    String number = (String)value;
    int val = Integer.parseInt(number);

        if(val > 5){
            if(val >= 5000) {
            setForeground(Color.black);
            setBackground(Color.red);
            }
            else {
            setForeground(Color.black);
            setBackground(Color.yellow);
            }
        }
        else{
        setBackground(Color.white);
        setForeground(Color.black);
        }
     setText(value !=null ? value.toString() : "");
    return this;
    }
    }