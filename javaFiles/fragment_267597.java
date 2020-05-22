import javax.swing.JOptionPane;

public final class CineVivero extends javax.swing.JFrame {

    public void popups() {

        Object[] opening = {
            "Bienvenido a Movie Counter"
            + "\n Esta aplicación fue hecha para Multicines Metro Vivero."
            + "\n Aquí se podra registrar el porcentaje de ocupación de"
            + "\n las instalaciones y los ingresos desde el momento que se"
            + "\n abre la aplicación.",};

        JOptionPane.showMessageDialog(null, opening, "Movie Counter", 2);
    }

    public CineVivero() {
        setSize(100, 100);
        setLocationRelativeTo(null);
        popups();
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new CineVivero().setVisible(true);
            }
        });
    }
}