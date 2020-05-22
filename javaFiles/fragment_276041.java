import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.text.DecimalFormat;
public class CustomCellRenderer extends DefaultTableCellRenderer implements TableCellRenderer
{
    public Component getTableCellRendererComponent
            (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
        JComponent cell = (JComponent) super.getTableCellRendererComponent
                (table, value, isSelected, hasFocus, row, column);
        // set color
        cell.setBackground(new Color(0xC8C8C8));
        cell.setForeground(new Color(0xFFFFFF));

        //set Alignment
        ((JLabel)cell).setHorizontalAlignment(SwingConstants.CENTER);

        //set selection colors
        if (isSelected){
            cell.setBackground(new Color(0x3399FF));
            cell.setForeground(new Color(0x000000)); // AM
        }else{
            // set decimals
            DecimalFormat DecimalFormatter = new DecimalFormat("#.00");
            value = DecimalFormatter.format(value);
            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
    return cell;
    }

}