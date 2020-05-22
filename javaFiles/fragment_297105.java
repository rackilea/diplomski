public class MainFrame extends javax.swing.JFrame {

    public long startTime;
    long elapsedSeconds;
    long elapsedTime;    
    public long secondsDisplay; // Segundos |
    public long elapsedMinutes; // Minutos   } os três principais
    public long elapsedHours;   // Horas    |


//initialize the string variables to empty strings 
    String ShowSeg = "";//
    String ShowMin = "";//
    String ShowHour = "";//
    /**
     * Creates new form SSMFrame
     */
    public MainFrame() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    //*A long code resided here*//                     
    private void StoCountActionPerformed(java.awt.event.ActionEvent evt) {                                         
    elapsedTime = System.currentTimeMillis() - startTime;
    elapsedSeconds = elapsedTime / 1000;
    secondsDisplay = elapsedSeconds % 60;
    elapsedMinutes = elapsedSeconds / 60;
    elapsedHours = elapsedMinutes / 60;


//set the strings to their long equivalents
ShowSeg = Long.toString(secondsDisplay);
ShowMin = Long.toString(elapsedMinutes );
ShowHour = Long.toString(elapsedHours);


        ShowETseg.setText(ShowSeg);
        ShowETmin.setText(ShowMin);
        ShowEThour.setText(ShowHour);