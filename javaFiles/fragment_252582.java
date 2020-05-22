public class DnyMesice extends JPanel {
    private JTextArea poznamkaDne;
    jButton tlacitkoDen;

    public DnyMesice (JTextArea jTextArea){
        this.poznamkaDne = jTextArea;
    }

    public void zobrazMesic(Calendar kalendar){
        for (c=1; c<30; c++){
                tlacitkoDen = new JButton(Integer.toString(denvMesici));
                 tlacitkoDen.addActionListener(new ActionListener(){
                     public void actionPerformed(ActionEvent evt) {
                         poznamkaDne.setText("New note");
                     };
                 });
                 add(tlacitkoDen);
        }
    }
}