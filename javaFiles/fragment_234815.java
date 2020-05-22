package yourPackageName;

import gov.nasa.worldwind.WorldWind;
import gov.nasa.worldwind.avlist.AVKey;
import gov.nasa.worldwind.geom.Position;
import gov.nasa.worldwind.layers.RenderableLayer;
import gov.nasa.worldwind.render.*;
import gov.nasa.worldwind.util.BasicDragger;
import gov.nasa.worldwindx.examples.ApplicationTemplate;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class YourclassName extends ApplicationTemplate
{
    public static class AppFrame extends ApplicationTemplate.AppFrame
    {
        private static JComboBox comboBox;
        private static JTextField textField;

        public AppFrame()
        {
            JPanel MainPanel = new JPanel();// new LayerPanel(this.wwjPanel.getWwd(), new Dimension(50, 50));

            GridLayout experimentLayout = new GridLayout(0,2);

            // Combobox
            JLabel labelCombo = new JLabel("Select Country");

            // Options in the combobox
            String[] options = { "India", "China", "USA", "Japan", "Russia" };
                comboBox = new JComboBox(options);
                comboBox.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                   // Do something when you select a value
                }
            });

            // Textfield
        JLabel labelTextField = new JLabel("Enter city");
         // Add controls

        textField = new JTextField();
        JPanel fieldPanel = new JPanel(experimentLayout);


        fieldPanel.add(labelCombo);
        fieldPanel.add(comboBox);
        fieldPanel.add(labelTextField);
        fieldPanel.add(textField);
        fieldPanel.add(new JButton("Go To city"));
        MainPanel.add(fieldPanel, BorderLayout.NORTH);

        this.getContentPane().add(MainPanel, BorderLayout.EAST);
    }
}
public static void main(String[] args)
{
    ApplicationTemplate.start("World Wind Example", AppFrame.class);
}
}