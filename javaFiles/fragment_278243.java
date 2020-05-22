# //file CustomDialog.java    
# import javax.swing.*;  
# import java.awt.*;  
# import java.awt.event.*;  
#    
# class CustomDialog extends JDialog implements ActionListener,Runnable{  
#    
# private JButton jButton_Yes = null;  
# private JButton jButton_NO = null;  
# private boolean OK = false;  
# private Thread thread = null;  
# private int seconds = 0;  
# private final int max = 30;//max number of seconds   
#    
# public CustomDialog(Frame frame){  
# super(frame,true);//modal  
# setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);  
#    
# Box hBox = Box.createHorizontalBox();  
#    
# jButton_Yes = new JButton("Yes");  
# jButton_Yes.addActionListener(this);  
#    
# jButton_NO = new JButton("NO");  
# jButton_NO.addActionListener(this);  
#    
# JLabel jLabel = new JLabel("How are you?");  
#    
# Container cont = getContentPane();  
# cont.setLayout(new BoxLayout(cont,BoxLayout.Y_AXIS));  
# cont.add(jLabel);  
# hBox.add(Box.createGlue());  
# hBox.add(jButton_Yes);  
# hBox.add(jButton_NO);  
# cont.add(hBox);  
#    
# pack();  
# thread = new Thread(this);  
# thread.start();  
# setVisible(true);  
# }  
#    
# public void actionPerformed(ActionEvent e){  
# if (e.getSource()==jButton_Yes)  
# OK = true;  
# if (e.getSource()==jButton_NO)  
# OK = false;  
# setVisible(false);  
# }  
#    
# public void run(){  
# while(seconds < max){  
# seconds++;  
# setTitle("OK? "+seconds);  
# try{  
# Thread.sleep(1000);  
# }catch (InterruptedException exc){  
# };  
# }  
# setVisible(false);  
# }  
#    
# public boolean isOk(){return OK;}  
#    
# public static void main(String[] args){//testing  
# CustomDialog cd = new CustomDialog(new JFrame());  
# System.out.println(cd.isOk());  
# cd = null;  
# System.exit(0);  
# }  
#    
# }//end