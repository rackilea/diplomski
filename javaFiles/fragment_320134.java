import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class BlingBlingTable
{
    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI()
    {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(createMainPanel());
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private static JPanel createMainPanel()
    {
        JPanel mainPanel = new JPanel(new BorderLayout());

        final JTable table = createTable();

        TableCellRenderer delegate = new DefaultTableCellRenderer();
        final BlinkCellRenderer blinkCellRenderer = 
            new BlinkCellRenderer(table, delegate);
        table.setDefaultRenderer(Object.class, blinkCellRenderer);
        mainPanel.add(table, BorderLayout.CENTER);

        createBlinkChecker(table, blinkCellRenderer);

        final JToggleButton blinkButton = new JToggleButton("Random blink");
        blinkButton.addActionListener(new ActionListener() 
        {
            int r;
            int c;

            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (blinkButton.isSelected())
                {
                    r = (int)(Math.random() * table.getRowCount());
                    c = (int)(Math.random() * table.getColumnCount());
                    blinkCellRenderer.addBlinkingCell(r, c);
                }
                else
                {
                    blinkCellRenderer.removeBlinkingCell(r, c);
                }
            }
        });
        mainPanel.add(blinkButton, BorderLayout.SOUTH);
        return mainPanel;
    }

    // Creates a table that contains strings that represent
    // points in time that are a few seconds in the future
    private static JTable createTable()
    {
        Vector<Vector<String>> rowDatas = new Vector<Vector<String>>();
        int rs = 3;
        int cs = 3;
        for (int r=0; r<rs; r++)
        {
            Vector<String> rowData = new Vector<String>();
            for (int c=0; c<cs; c++)
            {
                Calendar time = Calendar.getInstance();
                time.add(Calendar.SECOND, (c+(r * cs))*4);
                rowData.add(createTimeString(time));
            }
            Collections.shuffle(rowData);
            rowDatas.add(rowData);
        }
        Collections.shuffle(rowDatas);
        Vector<String> columnData = new Vector<String>();
        for (int c=0; c<3; c++)
        {
            columnData.add("Column "+c);
        }
        return new JTable(rowDatas, columnData);
    }

    // Creates a timer that regularly updates the blinking
    // state of all cells of the given table
    private static void createBlinkChecker(
        final JTable table, final BlinkCellRenderer blinkCellRenderer)
    {
        Timer timer = new Timer(500, new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                updateBlinkingState(table, blinkCellRenderer);
            }
        });
        timer.setInitialDelay(0);
        timer.start();
    }

    // Updates the blinking state of the specified cell
    // in the given table, using the #shouldBlink 
    // method below
    private static void updateBlinkingState(
        JTable table, BlinkCellRenderer blinkCellRenderer)
    {
        for (int r=0; r<table.getRowCount(); r++)
        {
            for (int c=0; c<table.getColumnCount(); c++)
            {
                if (shouldBlink(table, r, c))
                {
                    blinkCellRenderer.addBlinkingCell(r, c);
                }
                else
                {
                    blinkCellRenderer.removeBlinkingCell(r, c);
                }
            }
        }
    }

    // Returns whether the specified cell in the given 
    // table should currently blink
    private static boolean shouldBlink(JTable table, int r, int c)
    {
        Object value = table.getValueAt(r, c);
        Calendar cellTime = parseTime(String.valueOf(value));
        Calendar currentTime = Calendar.getInstance();
        cellTime.set(Calendar.YEAR, 
            currentTime.get(Calendar.YEAR));
        cellTime.set(Calendar.MONTH, 
            currentTime.get(Calendar.MONTH));
        cellTime.set(Calendar.DAY_OF_MONTH, 
            currentTime.get(Calendar.DAY_OF_MONTH));
        long difference = 
            currentTime.getTimeInMillis() - 
            cellTime.getTimeInMillis();

        // Blink for 10 seconds
        long blinkDurationInMS = 10000;
        return 
            difference >= 0 && 
            difference < blinkDurationInMS;
    }

    // The time format that will be used for creating
    // strings from calendar instances and for parsing
    private static final String TIME_FORMAT = " h:mm:ss a";
    private static final DateFormat DATE_FORMAT = 
        new SimpleDateFormat(TIME_FORMAT);

    // Creates a string containing the given time
    // in a particular format
    private static String createTimeString(Calendar time)
    {
        String timeString = DATE_FORMAT.format(time.getTime());
        return timeString;
    }

    // Parse the time from the given string
    private static Calendar parseTime(String timeString)
    {
        Calendar calendar = Calendar.getInstance();
        try
        {
            calendar.setTime(DATE_FORMAT.parse(timeString));
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        return calendar;
    }


    /**
     * A TableCellRenderer which can let particular cells of 
     * a JTable blink. That is, it switches the background
     * color at a regular interval and triggers a repaint
     * of the table. The cell renderer components whose 
     * background is switched are provided by a delegate
     * cell renderer
     */
    public static class BlinkCellRenderer extends DefaultTableCellRenderer          
    {
        /**
         * Serial UID
         */
        private static final long serialVersionUID = 6896646544236592534L;

        /**
         * Simple class storing the coordinates of a 
         * particular table cell
         */
        static class Cell
        {
            final int r;
            final int c;
            Cell(int r, int c)
            {
                this.r = r;
                this.c = c;
            }
            @Override
            public int hashCode()
            {
                return 31 * c + r;
            }
            @Override
            public boolean equals(Object object)
            {
                if (object instanceof Cell)
                {
                    Cell cell = (Cell)object;
                    return r == cell.r && c == cell.c; 
                }
                return false;
            }
        }

        /** 
         * The delegate cell renderer that provides the
         * cell renderer components
         */
        private final TableCellRenderer delegate;

        /**
         * The set of cells that are currently blinking
         */
        private final Set<Cell> blinkingCells = new HashSet<Cell>();

        /**
         * The current blinking state (that is, whether
         * the cells should be highlighted or not)
         */
        private boolean blinkingState = true;

        /**
         * Creates a BlinkCellRenderer that will let cells of
         * the given table blink. The cell renderer components
         * are provided by the given delegate
         * 
         * @param table The table
         * @param delegate The delegate
         */
        BlinkCellRenderer(final JTable table, TableCellRenderer delegate)
        {
            this.delegate = delegate;
            int delayMS = 250;
            Timer blinkingTimer = new Timer(delayMS, new ActionListener()
            {
                boolean timerBlinkingState = true;

                @Override
                public void actionPerformed(ActionEvent e)
                {
                    blinkingState = timerBlinkingState;
                    table.repaint();
                    timerBlinkingState = !timerBlinkingState;
                }
            });
            blinkingTimer.setInitialDelay(0);
            blinkingTimer.start();
        }

        /**
         * Add the cell with the given coordinates to the
         * set of cells that are currently blinking
         * 
         * @param r The row
         * @param c The column
         */
        void addBlinkingCell(int r, int c)
        {
            blinkingCells.add(new Cell(r, c));
        }

        /**
         * Remove the cell with the given coordinates from the
         * set of cells that are currently blinking
         * 
         * @param r The row
         * @param c The column
         */
        void removeBlinkingCell(int r, int c)
        {
            blinkingCells.remove(new Cell(r,c));
        }

        /**
         * Removes all blinking cells
         */
        void clearBlinkingCells()
        {
            blinkingCells.clear();
        }


        @Override
        public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column)
        {
            Component component = 
                delegate.getTableCellRendererComponent(
                    table, value, isSelected, hasFocus, row, column);
            Cell cell = new Cell(row, column);
            if (blinkingState && blinkingCells.contains(cell))
            {
                component.setBackground(Color.RED);
            }
            else
            {
                component.setBackground(null);
            }

            return component;
        } 
    }


}