public class Clock {

    public static void main(String[] args) {
        new Clock();
    }

    public Clock() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TimerPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TimerPane extends JPanel {

        private List<Segment> segments;
        private int tick = 0;

        public TimerPane() {
            setBorder(new EmptyBorder(9, 9, 9, 9));
            setLayout(new GridBagLayout());

            segments = new ArrayList<>(7);
            segments.add(new Segment(false));
            segments.add(new Segment(true));
            segments.add(new Segment(true));
            segments.add(new Segment(false));
            segments.add(new Segment(true));
            segments.add(new Segment(true));
            segments.add(new Segment(false));

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = 0;
            add(segments.get(0), gbc);
            gbc.gridx = 0;
            gbc.gridy++;
            add(segments.get(1), gbc);
            gbc.gridx = 2;
            add(segments.get(2), gbc);

            gbc.gridx = 1;
            gbc.gridy++;
            add(segments.get(3), gbc);
            gbc.gridy++;
            gbc.gridx = 0;
            add(segments.get(4), gbc);
            gbc.gridx = 2;
            add(segments.get(5), gbc);

            gbc.gridx = 1;
            gbc.gridy++;
            add(segments.get(6), gbc);

            Timer clock = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    List<Segment> active = new ArrayList<Segment>(segments);
                    switch (tick) {
                        case 0:
                            active.remove(segments.get(3));
                            break;
                        case 1:
                            active.remove(segments.get(0));
                            active.remove(segments.get(1));
                            active.remove(segments.get(3));
                            active.remove(segments.get(4));
                            active.remove(segments.get(6));
                            break;
                        case 2:
                            active.remove(segments.get(1));
                            active.remove(segments.get(5));
                            break;
                        case 3:
                            active.remove(segments.get(1));
                            active.remove(segments.get(4));
                            break;
                        case 4:
                            active.remove(segments.get(0));
                            active.remove(segments.get(4));
                            active.remove(segments.get(6));
                            break;
                        case 5:
                            active.remove(segments.get(2));
                            active.remove(segments.get(4));
                            break;
                        case 6:
                            active.remove(segments.get(2));
                            break;
                        case 7:
                            active.remove(segments.get(1));
                            active.remove(segments.get(3));
                            active.remove(segments.get(4));
                            active.remove(segments.get(6));
                            break;
                        case 8:
                            break;
                        case 9:
                            active.remove(segments.get(4));
                            active.remove(segments.get(6));
                            break;
                    }

                    List<Segment> inactive = new ArrayList<>(segments);
                    inactive.removeAll(active);

                    color(active, true);
                    color(inactive, false);

                    tick++;
                    if (tick > 9) {
                        tick = 0;
                    }

                    repaint();

                }

                protected void color(List<Segment> segments, boolean isActive) {
                    for (Segment segment : segments) {
                        segment.setActive(isActive);
                    }
                }
            });
            clock.setInitialDelay(0);
            clock.setRepeats(true);
            clock.start();

        }
    }

    public class Segment extends JPanel {

        protected Color alpha = new Color(0, 0, 0, 0);

        private boolean vertical;
        private boolean active;

        public Segment(boolean vertical) {
            this.vertical = vertical;
            setActive(false);
        }

        public void setActive(boolean value) {
            if (active != value) {
                active = value;
                if (active) {
                    setBackground(Color.LIGHT_GRAY);
                    setBorder(new LineBorder(Color.DARK_GRAY));
                } else {
                    setBackground(alpha);
                    setBorder(new LineBorder(alpha));
                }
            }
        }

        public boolean isActive() {
            return active;
        }

        @Override
        public Dimension getPreferredSize() {
            Dimension size = super.getPreferredSize();
            if (vertical) {
                size = new Dimension(5, 15);
            } else {
                size = new Dimension(15, 5);
            }
            return size;
        }
    }
}