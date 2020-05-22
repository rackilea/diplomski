import java.awt.Color;
import java.util.*;

public class WindowBuilderTest extends JFrame
{

private JPanel  contentPane;
private FontChanger fChanger; //<--NEW
private JTextArea txtTop; //<--NEW
private List<CheckBox> checkBoxes; //<--NEW

//Launch the application.
public static void main(final String[] args)
{
    EventQueue.invokeLater(new Runnable()
    {
        @Override
        public void run()
        {
            try
            {
                WindowBuilderTest frame = new WindowBuilderTest();
                frame.setVisible(true);
            }
            catch (final Exception e)
            {
                e.printStackTrace();
            }
        }
    });

    //just use this and comment out the whole Eventqueue block.
    /*
    WindowBuilderTest frame = new WindowBuilderTest();
    frame.setVisible(true);
    */
}

// Creating Frame
public WindowBuilderTest()
{
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 1280, 720);
    this.contentPane = new JPanel();
    this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(this.contentPane);
    this.contentPane.setLayout(null);

    // Create Font
    Font headfont = new Font("Serif", Font.PLAIN, 15);
    Font headfontRed = new Font("Serif", Font.PLAIN, 15);

    // Role Headlines
    txtTop = new JTextArea(); //<--NEW
    fChanger = new FontChanger(txtTop); //<--NEW
    checkBoxes = new ArrayList<CheckBox>(); //<-- NEW you will need to update your imports.

    txtTop.setEditable(false);
    txtTop.setText("TOP");
    txtTop.setBounds(180, 95, 32, 23);
    this.contentPane.add(txtTop);

    final JTextArea txtMid = new JTextArea();
    txtMid.setEditable(false);
    txtMid.setText("MID");
    txtMid.setBounds(252, 95, 32, 23);
    this.contentPane.add(txtMid);

    final JTextArea txtJng = new JTextArea();
    txtJng.setEditable(false);
    txtJng.setText("JNG");
    txtJng.setBounds(320, 95, 32, 23);
    this.contentPane.add(txtJng);

    final JTextArea txtAdc = new JTextArea();
    txtAdc.setEditable(false);
    txtAdc.setText("ADC");
    txtAdc.setBounds(389, 95, 32, 23);
    this.contentPane.add(txtAdc);

    final JTextArea txtSup = new JTextArea();
    txtSup.setEditable(false);
    txtSup.setText("SUP");
    txtSup.setBounds(453, 95, 32, 23);
    this.contentPane.add(txtSup);

    // Checkbox 1st row
    addCheckBox(183, 143, 23, 23, txtTop);
    addCheckBox(255, 143, 23, 23, txtMid);
    addCheckBox(322, 143, 23, 23, txtJng);
    addCheckBox(393, 143, 23, 23, txtAdc);
    addCheckBox(457, 143, 23, 23, txtSup);

    // Checkbox 2nd row
    addCheckBox(183, 200, 23, 23, txtTop);
    addCheckBox(255, 200, 23, 23, txtMid);
    addCheckBox(322, 200, 23, 23, txtJng);
    addCheckBox(393, 200, 23, 23, txtAdc);
    addCheckBox(457, 200, 23, 23, txtSup);

    // Checkbox 3nd row
    addCheckBox(183, 257, 23, 23, txtTop);
    addCheckBox(255, 257, 23, 23, txtMid);
    addCheckBox(322, 257, 23, 23, txtJng);
    addCheckBox(393, 257, 23, 23, txtAdc);
    addCheckBox(457, 257, 23, 23, txtSup);
}


private void addCheckBox(int x, int y, int width, int height)
{
    JCheckBox checkBox = new JCheckBox();
    checkBoxes.add(checkBox); // <-- NEW (add to checkboxes list)
    checkBox.setBounds(x, y, width, height);
    checkBox.addItemListener(fChanger); // <-- NEW (add the same listener to all)
    this.contentPane.add(checkBox);
}

class FontChanger implements ItemListener
{
    private JTextArea textArea;

    public FontChanger(JTextArea textArea)
    {
        this.textArea = textArea;
    }

    @Override
    public void itemStateChanged(ItemEvent e)
    {
        if (e.getStateChange() == ItemEvent.SELECTED)
        {
            Font boldFont = this.textArea.getFont().deriveFont(Font.BOLD);
            this.textArea.setForeground(Color.RED);
            this.textArea.setFont(boldFont);
        }
        else
        {
            //iterate through list of checkboxes to see if there's still one selected.
            boolean stillOneCheckBoxSelected = false;
            for(int i = 0; i < checkBoxes.size(); i++){
                if(checkBoxes.get(i).isSelected()){ // <- Verify the method here, not sure
                    stillOneCheckBoxSelected = true;
                    break;
                }
            }
            if(!stillOneCheckBoxSelected){//if no check boxes are selected, reset
                Font boldFont = this.textArea.getFont().deriveFont(Font.PLAIN);
                this.textArea.setForeground(Color.BLACK);
                this.textArea.setFont(boldFont);
            }
        }
    }
}