public static void main(String[] args) {
    JFrame f=new JFrame();  

    JButton b=new JButton("Get Password");  
    b.setBounds(50,120,120,30);  

    b.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){  

            String[] names = {"email", "email"};
            int index = (int) (Math.random() * names.length);
            String name = names[index];
            String msg = "Your random alt is " + name + " Have Fun and also DM me on Discord if this alt does not work @________#0000!";

            JOptionPane.showMessageDialog(f, msg);
        }  
    });  

    f.add(b);
    f.setSize(400,400);  
    f.setLayout(null);  
    f.setVisible(true);   
}