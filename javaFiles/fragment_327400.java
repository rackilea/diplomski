import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class DisplayView extends JFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }
                DisplayView view = new DisplayView();
                view.setDefaultCloseOperation(EXIT_ON_CLOSE);
                view.pack();
                view.setLocationRelativeTo(null);
                view.setVisible(true);
            }
        });
    }

    //constructor
    public DisplayView(LocalDate d) {
//      DisplayMenus menus = new DisplayMenus();
//      setJMenuBar(menus);

        DefaultDateModel model = new DefaultDateModel(d);

        JPanel body = new JPanel();
        body.setLayout(new BoxLayout(body, BoxLayout.Y_AXIS));

        DayView nowView = new DayView();
        nowView.setModel(model);
        DayView nextView = new DayView(1);
        nextView.setModel(model);

        body.add(nowView);
        body.add(nextView);
        add(new JScrollPane(body), BorderLayout.CENTER);

        JPanel footer = new JPanel();
        NavButtons navPanel = new NavButtons(model);
        JLabel focusPoint = new JLabel(DateTimeFormatter.ISO_DATE.format(model.getDate()));
        focusPoint.setForeground(Color.RED);
        footer.setLayout(new BorderLayout());
        footer.add(focusPoint, BorderLayout.CENTER);
        footer.add(navPanel, BorderLayout.EAST);
        footer.setBackground(Color.BLACK);
        add(footer, BorderLayout.SOUTH);

        pack();
    }

    public DisplayView() {
        this(LocalDate.now());
    }

    public interface DateModel {

        public LocalDate getDate();

        public void addObserver(Observer o);

        public void removeObserver(Observer o);
    }

    public interface MutableDateModel extends DateModel {

        public void setDate(LocalDate date);

    }

    public class DefaultDateModel extends Observable implements MutableDateModel {

        private LocalDate date;

        public DefaultDateModel(LocalDate date) {
            this.date = date;
        }

        @Override
        public void setDate(LocalDate date) {
            this.date = date;
            setChanged();
            notifyObservers();
        }

        @Override
        public LocalDate getDate() {
            return date;
        }

        @Override
        public void removeObserver(Observer o) {
            // I like the "remove" ;)
            deleteObserver(o);
        }

    }

    public class DayView extends JPanel implements Observer {
        private JLabel dateLabel;
        private DateModel model;
        private int offset;

        public DayView(int offset) {
            this.offset = offset;
            dateLabel = new JLabel("...");
            setLayout(new GridBagLayout());
            add(dateLabel);
        }

        public DayView() {
            this(0);
        }

        public void setModel(DateModel value) {
            if (model != null) {
                model.removeObserver(this);
            }
            this.model = value;
            if (model != null) {
                model.addObserver(this);
            }
            updateLabel();
        }

        public DateModel getModel() {
            return model;
        }

        protected void updateLabel() {
            DateModel model = getModel();
            if (model != null) {
                LocalDate offsetDate = model.getDate().plusDays(offset);
                dateLabel.setText(DateTimeFormatter.ISO_DATE.format(offsetDate));
            } else {
                dateLabel.setText("...");
            }
        }

        @Override
        public void update(Observable o, Object arg) {
            updateLabel();
        }

    }

    class NavButtons extends JPanel implements Observer {

        private JToolBar toolBar = new JToolBar("Navigation");
        private JButton weekBack = new JButton("<<");
        private JButton dayBack = new JButton("<");
        private JButton returnToday = new JButton("Today");
        private JButton nextDay = new JButton(">");
        private JButton nextWeek = new JButton(">>");
        private JButton calendar = new JButton("L");

        private MutableDateModel model;

        public NavButtons(MutableDateModel model) {
            weekBack.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    MutableDateModel model = getModel();
                    if (model != null) {
                        LocalDate newDate = model.getDate().minusDays(7);
                        model.setDate(newDate);
                    }
                }
            });
            dayBack.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    MutableDateModel model = getModel();
                    if (model != null) {
                        LocalDate newDate = model.getDate().minusDays(1);
                        model.setDate(newDate);
                    }
                }
            });
            returnToday.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    MutableDateModel model = getModel();
                    if (model != null) {
                        LocalDate newDate = LocalDate.now();
                        model.setDate(newDate);
                    }
                }
            });
            nextDay.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    MutableDateModel model = getModel();
                    if (model != null) {
                        LocalDate newDate = model.getDate().plusDays(1);
                        model.setDate(newDate);
                    }
                }
            });
            nextWeek.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    MutableDateModel model = getModel();
                    if (model != null) {
                        LocalDate newDate = model.getDate().plusDays(7);
                        model.setDate(newDate);
                    }
                }
            });

            toolBar.add(weekBack);
            toolBar.add(dayBack);
            toolBar.add(returnToday);
            toolBar.add(nextDay);
            toolBar.add(nextWeek);
//          toolBar.add(new GalileoMode());
            toolBar.add(calendar);
            add(toolBar);
            setModel(model);
        }

        public void setModel(MutableDateModel value) {
            if (model != null) {
                model.removeObserver(this);
            }
            this.model = value;
            if (model != null) {
                model.addObserver(this);
            }
        }

        public MutableDateModel getModel() {
            return model;
        }

        @Override
        public void update(Observable o, Object arg) {
            // models data has change!!
        }

        protected void setFocus(LocalDate newDate) {
            // No idea what this is suppose to do...
        }

    }
}