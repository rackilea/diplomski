import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Objects;

/**
 * @author Mikle Garin
 * @see https://stackoverflow.com/questions/56831494/how-to-change-the-color-of-the-line-dynamically
 */
public class TableRenderer
{
    public static void main ( String[] args )
    {
        SwingUtilities.invokeLater ( () -> {
            final JFrame frame = new JFrame ( "Table renderer" );
            frame.add ( new JScrollPane ( createTableSettingsReport () ) );
            frame.setDefaultCloseOperation ( WindowConstants.EXIT_ON_CLOSE );
            frame.pack ();
            frame.setLocationRelativeTo ( null );
            frame.setVisible ( true );
        } );
    }

    private static JTable createTableSettingsReport ()
    {
        final String[] dbColNames = new String[ 13 ];
        dbColNames[ 0 ] = "ID";
        dbColNames[ 1 ] = "Имя";
        dbColNames[ 2 ] = "Фамилия";
        dbColNames[ 3 ] = "Отчество";
        dbColNames[ 4 ] = "Дата прихода с ";
        dbColNames[ 5 ] = "Дата прихода до";
        dbColNames[ 6 ] = "Прибытие";
        dbColNames[ 7 ] = "Дата ухода с ";
        dbColNames[ 8 ] = "Дата ухода до";
        dbColNames[ 9 ] = "Убытие";
        dbColNames[ 10 ] = "Причина опоздания";
        dbColNames[ 11 ] = "Причина раннего ухода";
        dbColNames[ 12 ] = "ID лица";

        final String[][] data = {
                { "1", "Сергей", "Кирчин", "Васильевич",
                        "15.12.2002", "22.12.2002", "Да",
                        "25.08.2005", "26.08.2005", "Да",
                        "Болел", "Стало плохо", "123" },

                { "2", "Сергей", "Кирчин", "Васильевич",
                        "15.12.2002", "22.12.2002", "Нет",
                        "25.08.2005", "26.08.2005", "Да",
                        "Болел", "Стало плохо", "123" },

                { "3", "Сергей", "Кирчин", "Васильевич",
                        "15.12.2002", "22.12.2002", "Да",
                        "25.08.2005", "26.08.2005", "Нет",
                        "Болел", "Стало плохо", "123" }
        };

        final JTable jTblReport = new JTable ( new DefaultTableModel ( data, dbColNames ) );
        jTblReport.setSelectionMode ( ListSelectionModel.SINGLE_SELECTION );
        jTblReport.setRowSelectionAllowed ( true );
        jTblReport.setAutoCreateRowSorter ( true );
        jTblReport.getTableHeader ().setReorderingAllowed ( false );

        jTblReport.setDefaultRenderer ( Object.class, new MyCellRenderer () );

        // Optionally (if you have Boolean values, just easier to distinguish the data by type):
        // jTblReport.setDefaultRenderer ( Boolean.class, new MyBooleanCellRenderer () );

        jTblReport.getColumnModel ().getColumn ( 0 ).setPreferredWidth ( 10 );
        jTblReport.getColumnModel ().getColumn ( 1 ).setPreferredWidth ( 60 );
        jTblReport.getColumnModel ().getColumn ( 2 ).setPreferredWidth ( 60 );
        jTblReport.getColumnModel ().getColumn ( 3 ).setPreferredWidth ( 60 );
        jTblReport.getColumnModel ().getColumn ( 4 ).setPreferredWidth ( 60 );
        jTblReport.getColumnModel ().getColumn ( 5 ).setPreferredWidth ( 60 );
        jTblReport.getColumnModel ().getColumn ( 6 ).setPreferredWidth ( 60 );
        jTblReport.getColumnModel ().getColumn ( 7 ).setPreferredWidth ( 60 );
        jTblReport.getColumnModel ().getColumn ( 8 ).setPreferredWidth ( 60 );
        jTblReport.getColumnModel ().getColumn ( 9 ).setPreferredWidth ( 60 );
        jTblReport.getColumnModel ().getColumn ( 10 ).setPreferredWidth ( 60 );
        jTblReport.getColumnModel ().getColumn ( 10 ).setPreferredWidth ( 60 );
        jTblReport.getColumnModel ().getColumn ( 10 ).setPreferredWidth ( 60 );

        return jTblReport;
    }

    public static class MyCellRenderer extends DefaultTableCellRenderer
    {
        public MyCellRenderer ()
        {
            super ();
            setOpaque ( true );
            setBackground ( Color.WHITE );
        }

        @Override
        public Component getTableCellRendererComponent ( final JTable table, final Object value, final boolean isSelected,
                                                         final boolean hasFocus, final int row, final int column )
        {
            // Still need to call this to setup default stuff below
            super.getTableCellRendererComponent ( table, value, isSelected, hasFocus, row, column );

            // We should let selection color override our highlight
            if ( !isSelected )
            {
                // Checking conditions
                final boolean arrival = Objects.equals ( table.getValueAt ( row, 6 ), "Да" );
                final boolean departure = Objects.equals ( table.getValueAt ( row, 9 ), "Да" );
                setBackground ( !arrival || !departure ? Color.RED : Color.WHITE );
            }

            return this;
        }
    }
}