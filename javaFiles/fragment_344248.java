package airportproj;
    import java.awt.*;
    import java.awt.event.*;
    import java.util.*;
    import javax.swing.*;

    public class AirportProj {

        public static void main(String[] args) { new AirportProj();}

        // Fields
        private MainClass mainWindow;
        private LegClass legClass;
        private int legs, currentLeg;
        private double speed;
        private double totTime = 0;
        private double totDist = 0;
        private String[] airportNames;
        private double[] latitudes;
        private double[] longtitudes;
        Airport user;

        public AirportProj()  {
            class legsAndSpeedListener implements ActionListener
            {
                @Override
                public void actionPerformed(ActionEvent e) {
                    legs = mainWindow.getLegs();
                    speed = mainWindow.getSpeed();
                    mainWindow.dispose();
                    airportNames= new String[legs];
                    latitudes = new double[legs];
                    longtitudes = new double[legs];
                    currentLeg = 0;
                    class PortItinerary implements ActionListener
                    {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            airportNames[currentLeg] = legClass.getAirportName();
                            latitudes[currentLeg] = legClass.getLatitude();
                            longtitudes[currentLeg] = legClass.getLongtitude();
                            legClass.dispose();
                            if (++currentLeg < legs) {
                                legClass = new LegClass(new PortItinerary());
                            }else {
                                doWhateverYouWantToDoNext();
                            }
                        }
                    }

                    legClass = new LegClass(new PortItinerary());
                }
            }

            mainWindow = new MainClass(new legsAndSpeedListener());
        }

        public void doWhateverYouWantToDoNext() {
            for (int i = 0; i < legs; i ++) {
                System.out.println("Airport Name: " + airportNames[i]);
                System.out.println("Latitude: " + latitudes[i]);
                System.out.println("Longtitude: " + longtitudes[i]);
            }
        }
    }   

    class MainClass extends JFrame {
        private final int FRAME_WIDTH = 500;
        private final int FRAME_HEIGHT = 500;
        private JTextField legInput, speedInput;

        public MainClass(ActionListener listener) {
            // Frame window 1 : Contains Legs and Speed
            JPanel container = new JPanel();
            JLabel labelLegs = new JLabel("Legs:");
            JLabel labelSpeed = new JLabel("Speed:");
            legInput = new JTextField(5); // Leg field
            speedInput = new JTextField(5); // Speed field
            JButton button = new JButton("Ok");
            button.addActionListener(listener);

            setTitle("Legs and Speed");
            setSize(FRAME_WIDTH, FRAME_HEIGHT);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            // Add elements to panel and then to frame
            container.add(labelLegs);
            container.add(legInput); // Leg field
            container.add(labelSpeed);
            container.add(speedInput); // Speed field
            container.add(button);
            add(container);
            setVisible(true);
        }

        public int getLegs() {
            return Integer.parseInt(legInput.getText());
        }

        public double getSpeed() {
            return Double.parseDouble(speedInput.getText());
        }
    }

    class LegClass extends JFrame {
        private String name;
        private final int FRAME_WIDTH = 500;
        private final int FRAME_HEIGHT = 500;
        private JTextField airportInput, latitudeInput,longtitudeInput;

        public LegClass(ActionListener listener) {
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setSize(FRAME_WIDTH, FRAME_HEIGHT);

            JLabel airportName = new JLabel("Airport Name:");
            JLabel latitude = new JLabel("Latitude:");
            JLabel longtitude = new JLabel("Longitude");
            JPanel container = new JPanel();
            airportInput = new JTextField(5);
            latitudeInput = new JTextField(5);
            longtitudeInput = new JTextField(5);
            JButton okay = new JButton("Ok");
            okay.addActionListener(listener);

            container.add(airportName);// airport
            container.add(airportInput);
            container.add(latitude);  // latitude
            container.add(latitudeInput);
            container.add(longtitude);   // longtitude
            container.add(longtitudeInput);
            container.add(okay);
            add(container);

            setVisible(true);
        }

        public String getAirportName() {
            return airportInput.getText();
        }

        public double getLatitude() {
            return Double.parseDouble(latitudeInput.getText());
        }

        public double getLongtitude() {
            return Double.parseDouble(longtitudeInput.getText());
        }
    }