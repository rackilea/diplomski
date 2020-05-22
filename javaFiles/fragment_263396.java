public class testClass {
    public int testVar = 0;

    public void action(){
        jComboBox1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            int dificultad;
            if (jComboBox1.getSelectedItem() == "Facil") {
                dificultad = 10;
                System.out.println("Facil");
            } else if (jComboBox1.getSelectedItem() == "Intermedio") {
                dificultad = 8;
                System.out.println("Intermedio");
            } else if (jComboBox1.getSelectedItem() == "Dificil") {
                dificultad = 4;
                System.out.println("Dificl");
            } else if (jComboBox1.getSelectedItem() == "Extremo") {
                dificultad = 1;
                System.out.println("Extremo");
            }
            testVar = dificultad;
        }
        }
    }
}