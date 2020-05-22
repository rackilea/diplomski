public static void main(String... args) throws Exception {
    final List<Integer> holder = new LinkedList<Integer>();

    final JFrame frame = new JFrame("Test");

    final JTextField field = new JTextField("Enter some int + press enter");
    frame.add(field);
    field.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            synchronized (holder) {
                holder.add(Integer.parseInt(field.getText()));
                holder.notify();
            }
            frame.dispose();
        }
    });

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);

    // "logic" thread 
    synchronized (holder) {

        // wait for input from field
        while (holder.isEmpty())
            holder.wait();

        int nextInt = holder.remove(0);
        System.out.println(nextInt);
        //....
    }
}