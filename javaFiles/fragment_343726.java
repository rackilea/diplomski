public void addNewDicWordGUI()
{

           if(frameAdd==null)
               {

//Initialized only for the first time

            frameAdd = new JFrame("Add Word");


       frameAdd.setSize(350, 150);
       frameAdd.setLocation(100, 200);
       frameAdd.setResizable(false); 

       okNewWord.setSize(5,20);
       cancelNewWord.setSize(5,20);

       westAdd.add(add);
       eastAdd.setLayout(new GridLayout(2,1));
       eastAdd.add(okNewWord);
       eastAdd.add(cancelNewWord);
       southAdd.add(inputNewWord);

       frameAdd.add(westAdd, BorderLayout.WEST);
       frameAdd.add(eastAdd, BorderLayout.EAST);
       frameAdd.add(southAdd, BorderLayout.SOUTH);

       okNewWord.addActionListener(this);
       cancelNewWord.addActionListener(this);
       inputNewWord.addActionListener(this);
     }
      frameAdd.setVisible(true);
 }