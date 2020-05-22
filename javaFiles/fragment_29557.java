grid[x][y]=new JButton(" ");
grid[x][y].addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e){
    System.out.println("Hello");
    ((JButton)e.getSource()).setBackground(Color.red);
    }
});