ParentClass implements ActionListener 
{
int location =100;
 //...Codes codes..
 public void actionPerformed(ActionEvent e) {
 //perform null check 
  if (b1==(JButton)e.getSource()){
   b1.setLocation(location,100);
    location += 10;

    }
  }
}