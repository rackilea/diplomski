import javax.swing.*;

public class Helloworld {
    static JFrame frame;

    public Helloworld(){
    }

    public void run(){
        Object[] options = {"Vacanza","Cena","Prestazione","Bene"};
        int choice = JOptionPane.showOptionDialog(
                null,
                "Nuovo Prodotto",
                "Scegli il prodotto",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);
        if(choice == 0){
            System.out.println("0 selected");
        }
        else{
            System.out.println("Something else selected");
        }
    }

    public static void main(String[] args) {
        Helloworld hw = new Helloworld();
        hw.run();
    }
}