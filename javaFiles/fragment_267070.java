import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;


class Test { 
    private int i;

       private JPanel A;
       private JFrame f;
       private JLabel []l;

       Test(){
           f=new JFrame();
           A=new JPanel();
           f.setVisible(true);
           f.setSize(800, 800);
           f.setLayout(null);
           f.add(A);

           LoadLabels();
       }

    private void LoadLabels(){
         A.setLayout(new java.awt.GridBagLayout());

             l=new JLabel[15];
         for(int gx = 0; gx<15; gx++){
                     l[gx]= label(String.valueOf(gx+1));
                     l[gx].setBackground(Color.yellow);
                     l[gx].setBounds(30*gx, 30, 30, 20);
                     f.add(l[gx]);
         }             

     }      

    // JLabel is declared here:
       private JLabel label(String x){
            final JLabel l;
               l = new JLabel(x);
               l.setFont(new java.awt.Font("Tahoma", 0, 16));
               l.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
               l.setOpaque(true);
               l.setBorder(javax.swing.BorderFactory.createEtchedBorder());

               l.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

               l.addMouseListener(new java.awt.event.MouseAdapter() {
               @Override
               public void mouseClicked(java.awt.event.MouseEvent evt) {

                   System.out.println(l.getText());
               }
               });
               return l;
           }

    public static void main(String []args){
        new Test();
    }

}