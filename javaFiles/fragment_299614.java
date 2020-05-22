public class menu extends JFrame {
   private JTextField f_usuario, f_pass;
   private JButton b_ingreso;
   private String usuario = "java", pass = "entrar";
   private Usuario[] usuarios = new Usuario[5];


    public static void main(String args[]) {
      menu application = new menu();
      application.usuarios[0] = new Usuario("admin", "admin");
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   }
}