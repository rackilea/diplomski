/**
 * add the letter buttons to the screen
 */
public void addLetters()
{

    int x = (this.getWidth()/2)-60;
    int y = 300;
    int btnSize =20;
    int btnsAdded = 0;

    for (Character c : game.getAlphabet()) 
    {
        this.setLayout(null);
        JButton letter = new JButton(Character.toString(c).toUpperCase());
        letter.setLayout(null);
        letter.setSize(btnSize, btnSize);
        letter.setLocation(x,y);
        letter.setFont(new Font("Calibri",Font.PLAIN,10));
        letter.setMargin(new Insets(0,0,0,0));
        letter.setVisible(true); 




        this.add(letter);


        char guess = Character.toLowerCase(c);
        letter.addActionListener(new ActionListener() 
        {
        @Override public void actionPerformed(ActionEvent e) 
        {
        //actionPerformed code omitted because it is irrelevant
        }
      });
         x += 25;
         btnsAdded++;
         if(btnsAdded == 13)
         {
             x=(this.getWidth()/2)-60;
             y+=50;
         }
    }
}