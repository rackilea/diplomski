// code here is used to design the Jframe
package ics_sad_majorproject.gameoflifejava_1;

import java.util.Timer;
import java.util.TimerTask;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.SwingUtilities;

public class GameOfLife extends javax.swing.JFrame {

    int intperiod = 100;
    int wid = 50, hei = 50;
    boolean[][] currentMove = new boolean[hei][wid], nextMove = new boolean[hei][wid];
    boolean play;
    public static int intpopulation = 0;
    Image offScrImg;
    Graphics offScrGraph;
    public static int intGeneration = 0;
    Timer time = new Timer();
    // DiabolicWords
    // make task globally reachable in order to be able to set it from everywhere
    TimerTask task;

    public GameOfLife() {
        initComponents();
        offScrImg = createImage(jPanel2.getWidth(), jPanel2.getHeight());
        offScrGraph = offScrImg.getGraphics();

        // DiabolicWords
        // start timer and task for the first time
        this.restartTimerTask();
        repain();
    }

    // DiabolicWords
    // put the (re)creation of the TimerTask in a separate method
    private void restartTimerTask() {
        // DiabolicWords
        // if a task already exists, cancel()
        if (task != null) {
            task.cancel();
        }

        // DiabolicWords
        // create a new task
        task = new TimerTask() {
            public void run() {
                if (play == true) {
                    intGeneration++;
                    jLabel6.setText("Generation: " + intGeneration);
                    for (int i = 0; i < hei; i++) {
                        for (int j = 0; j < wid; j++) {
                            nextMove[i][j] = decide(i, j);
                        }
                    }
                    for (int i = 0; i < hei; i++) {
                        for (int j = 0; j < wid; j++) {
                            currentMove[i][j] = nextMove[i][j];
                        }
                    }
                    repain();
                }
            }
        };

        // DiabolicWords
        // run the new task
        time.scheduleAtFixedRate(task, 0, intperiod);
    }

    private boolean decide(int i, int j) {
        int neighbors = 0;
        if (j > 0) {
            if (currentMove[i][j - 1]) {
                neighbors++;
            }
            if (i > 0) {
                if (currentMove[i - 1][j - 1]) {
                    neighbors++;
                }
            }
            if (i < hei - 1) {
                if (currentMove[i + 1][j - 1]) {
                    neighbors++;
                }
            }
        }
        if (j < wid - 1) {
            if (currentMove[i][j + 1]) {
                neighbors++;
            }
            if (i > 0) {
                if (currentMove[i - 1][j + 1]) {
                    neighbors++;
                }
            }
            if (i < hei - 1) {
                if (currentMove[i + 1][j + 1]) {
                    neighbors++;
                }
            }
        }
        if (i > 0) {
            if (currentMove[i - 1][j]) {
                neighbors++;
            }
        }
        if (i < hei - 1) {
            if (currentMove[i + 1][j]) {
                neighbors++;
            }
        }
        if (currentMove[i][j] && neighbors < 2) {
            intpopulation--;
        }
        if (currentMove[i][j] && neighbors > 3) {
            intpopulation--;
        }
        if (currentMove[i][j] && neighbors == 3) {
            intpopulation--;
        }
        if (neighbors == 3) {
            intpopulation++;
        }
        jLabel5.setText("Population: " + Integer.toString(intpopulation));
        if (neighbors == 3) {
            return true;
        }
        if (currentMove[i][j] && neighbors == 2) {
            return true;
        }
        return false;
    }

    private void repain() {
        offScrGraph.setColor(Color.BLACK);
        offScrGraph.fillRect(0, 0, jPanel2.getWidth(), jPanel2.getHeight());
        for (int i = 0; i < hei; i++) {
            for (int j = 0; j < wid; j++) {
                if (currentMove[i][j]) {
                    offScrGraph.setColor(Color.getHSBColor((float) Math.random(), .8f, .8f));
                    int x = j * jPanel2.getWidth() / wid;
                    int y = i * jPanel2.getHeight() / hei;
                    offScrGraph.fillRect(x, y, jPanel2.getWidth() / wid, jPanel2.getHeight() / hei);
                }
            }
        }
        offScrGraph.setColor(Color.BLACK);
        for (int i = 1; i < hei; i++) {
            int y = i * jPanel2.getHeight() / hei;
            offScrGraph.drawLine(0, y, jPanel2.getWidth(), y);
        }
        for (int j = 1; j < wid; j++) {
            int x = j * jPanel2.getWidth() / wid;
            offScrGraph.drawLine(x, 0, x, jPanel2.getHeight());
        }
        jPanel2.getGraphics().drawImage(offScrImg, 0, 0, jPanel2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jSlider1 = new javax.swing.JSlider();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });
        jPanel2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jPanel2ComponentResized(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 387, Short.MAX_VALUE)
        );

        jButton2.setText("Reset");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("play");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setText("Time Slider");

        jLabel3.setText("Grid: ");

        jTextField1.setText("width:50");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField4.setText("height: 50");
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jSlider1.setMajorTickSpacing(10);
        jSlider1.setMaximum(500);
        jSlider1.setMinimum(1);
        jSlider1.setMinorTickSpacing(1);
        jSlider1.setPaintTicks(true);
        jSlider1.setValue(3000);
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });

        jLabel4.setText("100 milisecounds");

        jLabel5.setText("Population : 0");

        jLabel6.setText("Generation: 0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(323, 323, 323)
                                .addComponent(jLabel4))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addGap(2, 2, 2)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 294, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3)
                        .addComponent(jLabel2))
                    .addComponent(jSlider1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)
                        .addComponent(jButton2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4))
        );

        pack();
    }// </editor-fold>                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        currentMove = new boolean[hei][wid];
        intGeneration = 0;
        intpopulation = 0;
        jLabel6.setText("Generation: " + intGeneration);
        jLabel5.setText("population: " + intpopulation);
        repain();
    }                                        

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {                                     
        int j = wid * evt.getX() / jPanel2.getWidth();
        int i = hei * evt.getY() / jPanel2.getHeight();
        currentMove[i][j] = true;
        intpopulation++;
        jLabel5.setText("Population: " + Integer.toString(intpopulation));
        repain();
    }                                    

    private void jPanel2ComponentResized(java.awt.event.ComponentEvent evt) {                                         
        offScrImg = createImage(jPanel2.getWidth(), jPanel2.getHeight());
        offScrGraph = offScrImg.getGraphics();
        repain();
    }                                        

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {                                     
        int j = wid * evt.getX() / jPanel2.getWidth();
        int i = hei * evt.getY() / jPanel2.getHeight();
        if (SwingUtilities.isLeftMouseButton(evt)) {
            currentMove[i][j] = true;
            intpopulation++;
        } else {
            currentMove[i][j] = false;
        }
    }                                    

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        play = !play;
        if (play) {
            jButton3.setText("Pause");
        } else {
            jButton3.setText("play");
        }
        repain();
    }                                        

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        String text = jTextField4.getText();
        hei = Integer.valueOf(text);
        jTextField4.setText("Height: " + Integer.toString(hei));
        currentMove = new boolean[hei][wid];
        nextMove = new boolean[hei][wid];
        repain();
    }                                           

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        String text = jTextField1.getText();
        wid = Integer.valueOf(text);
        jTextField1.setText("width: " + Integer.toString(wid));
        currentMove = new boolean[hei][wid];
        nextMove = new boolean[hei][wid];
        repain();
    }                                           

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {                                      
        jLabel4.setText(Integer.toString(jSlider1.getValue()) + " milisecounds");
        intperiod = jSlider1.getValue();

        // DiabolicWords
        // the intperiod was changed. Restart the timer and task.
        this.restartTimerTask();
    }                                     

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameOfLife.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameOfLife.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameOfLife.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameOfLife.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameOfLife().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration                   

}