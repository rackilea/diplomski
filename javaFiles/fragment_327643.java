public class Assan extends RealEstate {

    public Assan() {
        zz.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent o)   {
               System.out.println("Cena");
           }
        });
    }


    public static void main(String[] args) {
        Assan v = new Assan();
        v.setUndecorated(true);
        v.setVisible(true);
        v.setBounds(350, 200, 600, 350);
        v.setForeground(Color.WHITE);
    }
}