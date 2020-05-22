// Create a new instance of "LimitPanel"
lp = new LimitPanel(st, 6);
// You can check this by using the hashCode of the object...
System.out.println(lp.hashCode());
pn.add(lp);

JButton sabt = new JButton("  ثبت  ");
sabt.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent arg0) {
        /*...*/
        // Use what ever was last assigned to "lp"
        jcb = lp.getChecks();
        // You can check this by using the hashCode of the object...
        System.out.println(lp.hashCode());
        /*...*/
    }
});