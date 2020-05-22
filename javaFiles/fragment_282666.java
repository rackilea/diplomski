ArrayList<JLabel> lb=new ArrayList<JLabel>(); //list of images

JFrame frame = new JFrame();
frame.setLayout(new GridLayout(rows,columns));//In your case (lb.size,2)
frame.setSize(300, 300);

//Now You need to Iterate through the List.

for(JLabel label:lb){
  frame.add(lb);  //Adding each image to the Frame
  frame.add(textLabel); //This is the text you want in side of image
 }

frame.setVisible(true);