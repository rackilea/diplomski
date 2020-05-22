import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;  
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Sorting extends JFrame{

    private static final int NUMBER_OF_BUTTONS = 7;

    public Sorting() {

        //divide and concur. don't try to put too many components into one or few panels
        //(which requires complex layout)
        //instead use sub panel and simple layouts

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //left panel for buttons
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(NUMBER_OF_BUTTONS,1));

        //add components (buttons) to buttons panel
        JButton insertionButton = new JButton("Insertion Sort");
        buttonsPanel.add(insertionButton);
        JButton selectionButton = new JButton("Selection Sort");
        buttonsPanel.add(selectionButton);
        JButton quickButton = new JButton("Quick Sort");
        buttonsPanel.add(quickButton);
        JButton mergeButton = new JButton("Merge Sort");
        buttonsPanel.add(mergeButton);
        JButton heapButton = new JButton("Heap Sort");
        buttonsPanel.add(heapButton);
        JButton radixButton = new JButton("Radix Sort");
        buttonsPanel.add(radixButton);

        //add buttons panel to content pane which by default uses border layout
        getContentPane().add(buttonsPanel, BorderLayout.WEST);

        //right panel for all the rest
        JPanel rightPanel = new JPanel();

        //add three panel to right panel
        //use gridbag to layout the 3 panels in the right panel
        GridBagLayout gbl_rightPanel = new GridBagLayout();
        gbl_rightPanel.columnWidths = new int[]{150, 0};
        gbl_rightPanel.rowHeights = new int[]{0, 47, 47, 0};
        gbl_rightPanel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
        gbl_rightPanel.rowWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
        rightPanel.setLayout(gbl_rightPanel);

        //add right panel to content pane
        getContentPane().add(rightPanel, BorderLayout.EAST);

        //winning algo
        //to add titled border see: http://www.javacodex.com/More-Examples/2/11
        JPanel algo = new JPanel();
        algo.setLayout(new FlowLayout(FlowLayout.CENTER));
        //add components to algo panel
        JTextField winningField = new JTextField(15);
        algo.add( winningField);

        GridBagConstraints gbc_algo = new GridBagConstraints();
        gbc_algo.fill = GridBagConstraints.HORIZONTAL;
        gbc_algo.insets = new Insets(0, 0, 5, 0);
        gbc_algo.gridx = 0;
        gbc_algo.gridy = 0;
        rightPanel.add(algo, gbc_algo);

        //properties
        JPanel propertiesPanel = new JPanel();
        propertiesPanel.setBackground(Color.YELLOW);//for demonstration purpose
        //TODO: set gridbag layout to propertiesPanel, and add components

        //add properties panel to right panel
        GridBagConstraints gbc_propertiesPanel = new GridBagConstraints();
        gbc_propertiesPanel.fill = GridBagConstraints.BOTH;
        gbc_propertiesPanel.insets = new Insets(0, 0, 5, 0);
        gbc_propertiesPanel.gridx = 0;
        gbc_propertiesPanel.gridy = 1;
        rightPanel.add(propertiesPanel, gbc_propertiesPanel);

        //results
        JPanel resultsPanel = new JPanel();
        resultsPanel.setBackground(Color.CYAN);//for demonstration purpose
        //TODO: set gridbag layout to resultsPanel, and add components

        //add resultsPanel panel to right panel
        GridBagConstraints gbc_resultsPanel = new GridBagConstraints();
        gbc_resultsPanel.fill = GridBagConstraints.BOTH;
        gbc_resultsPanel.gridx = 0;
        gbc_resultsPanel.gridy = 2;
        rightPanel.add(resultsPanel, gbc_resultsPanel);

        pack();
        setVisible(true);
    }

    public static void main(String args[]) {
        new Sorting();
    }
}