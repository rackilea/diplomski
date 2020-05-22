import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class CinemaTicketMachine {

    private JComponent ui = null;
    private JToggleButton[] seats = new JToggleButton[80];
    private JTextArea selectedSeats = new JTextArea(3, 40);

    CinemaTicketMachine() {
        initUI();
    }

    public void initUI() {
        if (ui!=null) return;

        ui = new JPanel(new BorderLayout(4,4));
        ui.setBorder(new EmptyBorder(4,4,4,4));

        selectedSeats.setLineWrap(true);
        selectedSeats.setWrapStyleWord(true);
        selectedSeats.setEditable(false);
        ui.add(new JScrollPane(selectedSeats), BorderLayout.PAGE_END);

        JPanel cinemaFloor = new JPanel(new BorderLayout(40, 0));
        cinemaFloor.setBorder(new TitledBorder("Available Seats"));
        ui.add(cinemaFloor, BorderLayout.CENTER);
        JPanel leftStall = new JPanel(new GridLayout(0, 2, 2, 2));
        JPanel centerStall = new JPanel(new GridLayout(0, 4, 2, 2));
        JPanel rightStall = new JPanel(new GridLayout(0, 2, 2, 2));

        cinemaFloor.add(leftStall, BorderLayout.WEST);
        cinemaFloor.add(centerStall, BorderLayout.CENTER);
        cinemaFloor.add(rightStall, BorderLayout.EAST);

        ActionListener seatSelectionListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                showSelectedSeats();
            }
        };

        for (int ii=0; ii <seats.length; ii++) {
            JToggleButton tb = new JToggleButton("S-" + (ii+1));
            tb.addActionListener(seatSelectionListener);
            seats[ii] = tb;
            int colIndex = ii%8;
            if (colIndex<2) {
                leftStall.add(tb);
            } else if (colIndex<6) {
                centerStall.add(tb);
            } else {
                rightStall.add(tb);
            }
        }
    }

    private void showSelectedSeats() {
        StringBuilder sb = new StringBuilder();
        for (int ii=0; ii<seats.length; ii++) {
            JToggleButton tb = seats[ii];
            if (tb.isSelected()) {
                sb.append(tb.getText());
                sb.append(", ");
            }
        }
        String s = sb.toString();
        if (s.length()>0) {
            s = s.substring(0, s.length()-2);
        }
        selectedSeats.setText(s);
    }

    public JComponent getUI() {
        return ui;
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                CinemaTicketMachine o = new CinemaTicketMachine();

                JFrame f = new JFrame(o.getClass().getSimpleName());
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationByPlatform(true);

                f.setContentPane(o.getUI());
                f.pack();
                f.setMinimumSize(f.getSize());

                f.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}