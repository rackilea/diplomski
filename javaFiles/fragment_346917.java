import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

import com.ggl.spirograph.model.ControlModel;

public class ControlPanel {

    protected static final Insets entryInsets = new Insets(0, 10, 4, 10);
    protected static final Insets titleInsets = new Insets(0, 10, 20, 10);

    protected ControlModel model;

    protected DrawingPanel drawingPanel;

    protected JButton drawButton;
    protected JButton stopButton;
    protected JButton resetButton;
    protected JButton foregroundColorButton;
    protected JButton backgroundColorButton;

    protected JLabel message;

    protected JPanel panel;

    protected JTextField outerCircleField;
    protected JTextField innerCircleField;
    protected JTextField penLocationField;
    protected JTextField penSizeField;
    protected JTextField penFadeField;

    protected JToggleButton animationToggleButton;
    protected JToggleButton fastToggleButton;

    protected static final int messageLength = 100;
    protected String blankMessage;

    public ControlPanel(ControlModel model) {
        this.model = model;
        this.blankMessage = createBlankMessage();
        createPartControl();
        setFieldValues();
        setColorValues();
    }

    public void setDrawingPanel(DrawingPanel drawingPanel) {
        this.drawingPanel = drawingPanel;
    }

    protected String createBlankMessage() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < messageLength / 4; i++) {
            sb.append("    ");
        }
        return sb.toString();
    }

    protected void createPartControl() {
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        int gridy = 0;

        JLabel title = new JLabel("Spirograph Parameters");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        addComponent(panel, title, 0, gridy++, 4, 1, titleInsets,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);

        resetButton = new JButton("Reset Default Parameters");
        resetButton.setHorizontalAlignment(SwingConstants.CENTER);
        resetButton.addActionListener(new ResetButtonListener());
        addComponent(panel, resetButton, 0, gridy++, 4, 1, entryInsets,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);

        JLabel outerCircleLabel = new JLabel("Outer circle radius:");
        outerCircleLabel.setHorizontalAlignment(SwingConstants.LEFT);
        addComponent(panel, outerCircleLabel, 0, gridy, 2, 1, entryInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        outerCircleField = new JTextField(5);
        outerCircleField.setHorizontalAlignment(SwingConstants.LEFT);
        addComponent(panel, outerCircleField, 2, gridy++, 2, 1, entryInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JLabel innerCircleLabel = new JLabel("Inner circle radius:");
        innerCircleLabel.setHorizontalAlignment(SwingConstants.LEFT);
        addComponent(panel, innerCircleLabel, 0, gridy, 2, 1, entryInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        innerCircleField = new JTextField(5);
        innerCircleField.setHorizontalAlignment(SwingConstants.LEFT);
        addComponent(panel, innerCircleField, 2, gridy++, 2, 1, entryInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JLabel penLocationLabel = new JLabel("Pen location radius:");
        penLocationLabel.setHorizontalAlignment(SwingConstants.LEFT);
        addComponent(panel, penLocationLabel, 0, gridy, 2, 1, entryInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        penLocationField = new JTextField(5);
        penLocationField.setHorizontalAlignment(SwingConstants.LEFT);
        addComponent(panel, penLocationField, 2, gridy++, 2, 1, entryInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JLabel penSizeLabel = new JLabel("Pen size:");
        penSizeLabel.setHorizontalAlignment(SwingConstants.LEFT);
        addComponent(panel, penSizeLabel, 0, gridy, 2, 1, entryInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        penSizeField = new JTextField(5);
        penSizeField.setHorizontalAlignment(SwingConstants.LEFT);
        addComponent(panel, penSizeField, 2, gridy++, 2, 1, entryInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        message = new JLabel(blankMessage);
        message.setForeground(Color.RED);
        message.setHorizontalAlignment(SwingConstants.LEFT);
        addComponent(panel, message, 0, gridy++, 4, 1, titleInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        title = new JLabel("Drawing Speed");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        addComponent(panel, title, 0, gridy++, 4, 1, titleInsets,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 4, 0));

        animationToggleButton = new JToggleButton("Animated");
        animationToggleButton.setSelected(model.isAnimated());
        animationToggleButton.setHorizontalAlignment(SwingConstants.CENTER);
        animationToggleButton.addActionListener(new DrawingSpeedListener(
                animationToggleButton));
        buttonPanel.add(animationToggleButton);

        fastToggleButton = new JToggleButton("Fast");
        fastToggleButton.setSelected(!model.isAnimated());
        fastToggleButton.setHorizontalAlignment(SwingConstants.CENTER);
        fastToggleButton.addActionListener(new DrawingSpeedListener(
                fastToggleButton));
        buttonPanel.add(fastToggleButton);

        addComponent(panel, buttonPanel, 0, gridy++, 4, 1, titleInsets,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);

        title = new JLabel("Drawing Colors");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        addComponent(panel, title, 0, gridy++, 4, 1, titleInsets,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);

        buttonPanel = new JPanel(new GridLayout(1, 2, 4, 0));

        foregroundColorButton = new JButton("Pen");
        foregroundColorButton.setHorizontalAlignment(SwingConstants.CENTER);
        foregroundColorButton.addActionListener(new ColorSelectListener(
                foregroundColorButton));
        buttonPanel.add(foregroundColorButton);

        backgroundColorButton = new JButton("Paper");
        backgroundColorButton.setHorizontalAlignment(SwingConstants.CENTER);
        backgroundColorButton.addActionListener(new ColorSelectListener(
                backgroundColorButton));
        buttonPanel.add(backgroundColorButton);

        addComponent(panel, buttonPanel, 0, gridy++, 4, 1, titleInsets,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);

        title = new JLabel("Drawing Controls");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        addComponent(panel, title, 0, gridy++, 4, 1, titleInsets,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);

        buttonPanel = new JPanel(new GridLayout(1, 2, 4, 0));

        drawButton = new JButton("Draw");
        drawButton.setHorizontalAlignment(SwingConstants.CENTER);
        drawButton.addActionListener(new DrawButtonListener());
        buttonPanel.add(drawButton);

        stopButton = new JButton("Stop");
        stopButton.setHorizontalAlignment(SwingConstants.CENTER);
        stopButton.addActionListener(new StopButtonListener());
        buttonPanel.add(stopButton);

        addComponent(panel, buttonPanel, 0, gridy++, 4, 1, titleInsets,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);
    }

    protected void addComponent(Container container, Component component,
            int gridx, int gridy, int gridwidth, int gridheight, 
            Insets insets, int anchor, int fill) {
        GridBagConstraints gbc = new GridBagConstraints(gridx, gridy,
                gridwidth, gridheight, 1.0, 1.0, anchor, fill, insets, 0, 0);
        container.add(component, gbc);
    }

    protected void setFieldValues() {
        outerCircleField.setText(Integer.toString(model.getOuterCircle()));
        innerCircleField.setText(Integer.toString(model.getInnerCircle()));
        penLocationField.setText(Integer.toString(model.getPenLocation()));
        penSizeField.setText(Integer.toString(model.getPenSize()));
    }

    protected void setColorValues() {
        foregroundColorButton.setForeground(model.getBackgroundColor());
        foregroundColorButton.setBackground(model.getPenColor());

        backgroundColorButton.setForeground(model.getPenColor());
        backgroundColorButton.setBackground(model.getBackgroundColor());
    }

    public JPanel getPanel() {
        return panel;
    }

    public class ResetButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            model.init();
            setFieldValues();
        }

    }

    public class StopButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            drawingPanel.stop();
        }

    }

    public class DrawButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            message.setText(blankMessage);

            int ocTest = isNumeric(outerCircleField.getText());
            int icTest = isNumeric(innerCircleField.getText());
            int plTest = isNumeric(penLocationField.getText());
            int psTest = isNumeric(penSizeField.getText());

            boolean isInvalid = false;

            if (psTest < 0) {
                message.setText("Pen size is not a valid integer");
                isInvalid = true;
            }

            if (plTest < 0) {
                message.setText("Pen location radius is not a valid integer");
                isInvalid = true;
            }

            if (icTest < 0) {
                message.setText("Inner circle radius is not a valid integer");
                isInvalid = true;
            }

            if (ocTest < 0) {
                message.setText("Outer circle radius is not a valid integer");
                isInvalid = true;
            }

            if (isInvalid) {
                return;
            }

            if (ocTest > 1000) {
                message.setText("The outer circle cannot be larger than 1000");
                isInvalid = true;
            }

            if (ocTest <= icTest) {
                message.setText("The inner circle must be smaller than the outer circle");
                isInvalid = true;
            }

            if (icTest <= plTest) {
                message.setText("The pen location must be smaller than the inner circle");
                isInvalid = true;
            }

            if (isInvalid) {
                return;
            }

            model.setOuterCircle(ocTest);
            model.setInnerCircle(icTest);
            model.setPenLocation(plTest);
            model.setPenSize(psTest);

            drawingPanel.draw(model.isAnimated());
        }

        protected int isNumeric(String field) {
            try {
                return Integer.parseInt(field);
            } catch (NumberFormatException e) {
                return Integer.MIN_VALUE;
            }
        }

    }

    public class DrawingSpeedListener implements ActionListener {

        JToggleButton selectedButton;

        public DrawingSpeedListener(JToggleButton selectedButton) {
            this.selectedButton = selectedButton;
        }

        @Override
        public void actionPerformed(ActionEvent arg0) {
            if (selectedButton.equals(animationToggleButton)) {
                model.setAnimated(true);
            } else {
                model.setAnimated(false);
            }

            animationToggleButton.setSelected(model.isAnimated());
            fastToggleButton.setSelected(!model.isAnimated());
        }

    }

    public class ColorSelectListener implements ActionListener {

        JButton selectedButton;

        public ColorSelectListener(JButton selectedButton) {
            this.selectedButton = selectedButton;
        }

        @Override
        public void actionPerformed(ActionEvent arg0) {
            if (selectedButton.equals(foregroundColorButton)) {
                Color initialColor = model.getPenColor();
                Color selectedColor = JColorChooser.showDialog(drawingPanel,
                        "Select pen color", initialColor);
                if (selectedColor != null) {
                    model.setPenColor(selectedColor);
                }
            } else if (selectedButton.equals(backgroundColorButton)) {
                Color initialColor = model.getBackgroundColor();
                Color selectedColor = JColorChooser.showDialog(drawingPanel,
                        "Select paper color", initialColor);
                if (selectedColor != null) {
                    model.setBackgroundColor(selectedColor);
                }
            }
            setColorValues();
        }

    }

 }