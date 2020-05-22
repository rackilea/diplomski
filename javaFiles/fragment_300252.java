public class koodibaas extends Frame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private int[] array;

    private TextField tfCount;

    private Label lblCount;

    private Button btnCount;

    public koodibaas() {
        setLayout(new FlowLayout());

        lblCount = new Label("ENTER CODE?");

        add(lblCount);
        tfCount = new TextField("0", 10);
        add(tfCount);

        btnCount = new Button("GIVE ANSWER");
        add(btnCount);

        btnCount.addActionListener(this);

        setTitle("koodibaas");
        setSize(400, 150);
        setVisible(true);
        second(); // call second to initialize array 

    }

    public void second() {
        array = new int[30];
        array[0] = 111111;
        array[1] = 888888;
        array[2] = 333333;
        array[3] = 555555;
        array[4] = 111111;
        array[5] = 643208;
        array[6] = 643208;
        array[7] = 643208;
        array[8] = 643208;
        array[9] = 643208;
        array[10] = 643208;
        array[11] = 643208;
        array[12] = 643208;
        array[13] = 643208;
        array[14] = 643208;
        array[15] = 643208;
        array[16] = 643208;
        array[17] = 643208;
        array[18] = 643208;
        array[19] = 643208;
        array[20] = 643208;
        array[21] = 643208;
        array[22] = 643208;
        array[23] = 643208;
        array[24] = 643208;
        array[25] = 643208;
        array[26] = 643208;
        array[27] = 643208;
        array[28] = 643208;
        array[29] = 643208;

    }

    public static void main(String[] args) {
        koodibaas app = new koodibaas();
    }

    @Override
    public void actionPerformed(ActionEvent evt) {

        int number = Integer.parseInt(tfCount.getText());
        tfCount.setText(String.valueOf(array[number]));
    }

}