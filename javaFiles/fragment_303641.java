public class Oblig8 extends JFrame {

static int valg1;
static int valg2;

public static void main(String[] args) {
    ...

    Spiller1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            valg1 = JOptionPane.showOptionDialog(Frame,
                    "Spiller 1 har trykket",
                    "Stein - Saks - Papir",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    muligheter,
                    muligheter[2]);
            System.out.println(valg1);
        }
    });
    ...
}
}