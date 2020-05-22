import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

public class BallAnimation
{
    private int x;
    private int y;
    private boolean positiveX;
    private boolean positiveY;
    private boolean isTimerRunning; 
    private int speedValue;
    private int diameter; 
    private DrawingArea drawingArea;    
    private Timer timer;
    private int colourCounter;
     Color[] colours = {
                            Color.BLUE.darker(),
                            Color.MAGENTA.darker(),
                            Color.BLACK.darker(),
                            Color.RED.darker(),
                            Color.PINK.darker(),
                            Color.CYAN.darker(),
                            Color.DARK_GRAY.darker(),
                            Color.YELLOW.darker(),
                            Color.GREEN.darker()
                       };

    private Color backgroundColour;
    private Color foregroundColour; 

    private ActionListener timerAction = new ActionListener()
    {
        public void actionPerformed(ActionEvent ae)
        {
            x = getX();
            y = getY();
            drawingArea.setXYColourValues(x, y, backgroundColour
                                        , foregroundColour);
        }       
    };

    private JPanel buttonPanel;
    private JButton startStopButton;
    private JButton speedIncButton;
    private JButton speedDecButton;
    private JButton resetButton;
    private JButton colourButton;
    private JButton exitButton;

    private ComponentAdapter componentAdapter = new ComponentAdapter()
    {
        public void componentResized(ComponentEvent ce)
        {
            timer.restart();
        }
    };  

    public BallAnimation()
    {
        x = y = 0;
        positiveX = positiveY = true;
        speedValue = 1;
        colourCounter = 0;
        isTimerRunning = false;
        diameter = 50;
        backgroundColour = Color.WHITE.brighter();
        foregroundColour = colours[colourCounter];
        timer = new Timer(10, timerAction);
    }

    private void createAndDisplayGUI()
    {
        JFrame frame = new JFrame("Ball Animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);

        drawingArea = new DrawingArea(x, y
                            , backgroundColour, foregroundColour, diameter);
        drawingArea.addComponentListener(componentAdapter);

        frame.add(makeButtonPanel(), BorderLayout.LINE_START);
        frame.add(drawingArea, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);     
    }

    private JPanel makeButtonPanel()
    {
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0, 1));
        buttonPanel.setBorder(BorderFactory.createLineBorder(
                                    Color.DARK_GRAY, 5, true));

        colourButton = new JButton("BALL COLOUR");
        colourButton.setOpaque(true);
        colourButton.setBackground(colours[colourCounter]);
        colourButton.setForeground(Color.WHITE);
        colourButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                System.out.println("COLOUR JButton Clicked!");
                if (timer.isRunning())
                    timer.stop();
                colourCounter++;
                if (colourCounter == 9)
                    colourCounter = 0;
                foregroundColour = colours[colourCounter];
                drawingArea.setXYColourValues(x, y, backgroundColour
                                                    , foregroundColour);
                colourButton.setBackground(foregroundColour);
                if (!timer.isRunning())
                    timer.start();
            }
        });
        colourButton.setBorder(BorderFactory.createLineBorder(
                                    Color.WHITE, 2, true));
        buttonPanel.add(colourButton);

        return buttonPanel;
    }

    private int getX()
    {
        if (x < 0)
            positiveX = true;
        else if (x >= drawingArea.getWidth() - diameter)
            positiveX = false;
        return (calculateX());
    }

    private int calculateX()
    {
        if (positiveX)
            return (x += speedValue);
        else
            return (x -= speedValue);
    }

    private int getY()
    {
        if (y < 0)
            positiveY = true;
        else if (y >= drawingArea.getHeight() - diameter)
            positiveY = false;
        return (calculateY());
    }

    private int calculateY()
    {
        if (positiveY)
            return (y += speedValue);
        else 
            return (y -= speedValue);
    }

    public static void main(String... args)
    {
        Runnable runnable = new Runnable()
        {
            public void run()
            {
                new BallAnimation().createAndDisplayGUI();
            }
        };
        SwingUtilities.invokeLater(runnable);
    }
}

class DrawingArea extends JComponent
{
    private int x;
    private int y;
    private int ballDiameter;
    private Color backgroundColor;
    private Color foregroundColor;

    public DrawingArea(int x, int y
                , Color bColor, Color fColor, int dia)
    {
        this.x = x;
        this.y = y;
        ballDiameter = dia;
        backgroundColor = bColor;
        foregroundColor = fColor;
        setBorder(BorderFactory.createLineBorder(
                        Color.DARK_GRAY.darker(), 5, true));
    }

    public void setXYColourValues(int x, int y
                            , Color bColor, Color fColor)
    {
        this.x = x;
        this.y = y;
        backgroundColor = bColor;
        foregroundColor = fColor;
        repaint();
    }

    public Dimension getPreferredSize()
    {
        return (new Dimension(500, 400));
    }

    public void paintComponent(Graphics g)
    {
        g.setColor(backgroundColor);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(foregroundColor);
        g.fillOval(x, y, ballDiameter, ballDiameter);
    }
}