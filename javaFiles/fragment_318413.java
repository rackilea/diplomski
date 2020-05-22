import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Poker extends JApplet implements ActionListener, ListSelectionListener {

    private DefaultListModel listModel = new DefaultListModel();
    JList jList = new JList(listModel);
    JButton dealButton = new JButton("Deal card");
    JButton quitButton = new JButton("Quit");  
    JButton finishButton = new JButton("finish");
    JPanel panel = new JPanel();
    JPanel jPanel = new JPanel();

    private Poker.Card deck[];
    private int currentCard;
    private int money;
    String faces[] = {
            "Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", 
            "Ten", "Jack", 
            "Queen", "King", "Ace"
    };
    String suits[] = {
            "Hearts", "Diamonds", "Clubs", "Spades"
    };
    private boolean card1State;
    private boolean card2State;
    private boolean card3State;
    private boolean card4State;
    private boolean card5State;
    private  Poker.Card hand[];
    private boolean pressed;
    private boolean nothing;
    private boolean pair;
    private boolean twoPair;
    private boolean threeKind;
    private boolean fourKind;
    private boolean fullHouse;
    private boolean flush;
    private boolean straight;
    private boolean royalStraight;
    private boolean straightFlush;
    private boolean RoyalFlush;
    private final int ROYALFLUSH = 8;
    private int value;
    private boolean firstDeal;

    @Override
    public void init(){

        this.setSize(500, 500);

        jList.addListSelectionListener(this);
        jList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        hand = new Poker.Card[5];
        deck = new Poker.Card[52];
        currentCard = -1;

        for(int i = 0; i < deck.length; i++)
            deck[i] = new Poker.Card(faces[i % 13], suits[i / 13]);

        listModel.setSize(5);

        dealButton.addActionListener(this);
        finishButton.addActionListener(this);
        quitButton.addActionListener(this);

        finishButton.setEnabled(false);

        // c.setLayout(new FlowLayout());
        panel.add(dealButton);         
        panel.add(finishButton); 
        panel.add(quitButton); 

        add(panel, BorderLayout.SOUTH);         

        jPanel.add(jList);
        add(jPanel,  BorderLayout.NORTH);

        setVisible(true);

    }


    class Card 
    {
        @Override
        public String toString()
        {
            return face + " of " + suit + "\n";
        }

        public String getFace()
        {
            return face;
        }

        public String getSuit()
        {
            return suit;
        }

        private String face;
        private String suit;

        public Card(String s, String s1)
        {
            face = s;
            suit = s1;
        }
    }


    @Override
    public void valueChanged(ListSelectionEvent event) {
        JList source = (JList) event.getSource();
        java.util.List values = source.getSelectedValuesList();
        listModel.removeElement(values);
        changeCards();
    }


    @Override
    public void actionPerformed(ActionEvent event) {
        Poker.Card card = null;
        int i = 5;
        if(event.getSource() == dealButton){
            pressed = true;
            dealButton.setEnabled(false);
            finishButton.setEnabled(true);

            for(int j = 0; j < 5; j++){
                card = dealCard();
                hand[j] = card;
                listModel.setElementAt(hand[j], j);
            }
            if(money < -1000){
                JOptionPane.showMessageDialog(null, "GAME OVER. ");
                System.exit(0);
            }
        }else if( event.getSource() == finishButton){

            // still needs implementation

        } else if (event.getSource() == quitButton) {

            pressed = true;

            int confirmed = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to exit?", "User Confirmation",
                    JOptionPane.YES_NO_OPTION);
            if (confirmed == JOptionPane.YES_OPTION) {

                dealButton.setEnabled(false);
                finishButton.setEnabled(false);
                quitButton.setEnabled(false);
                System.exit(0);
            }
        }
        this.setVisible(true);
        this.validate();
    }

    public void giveMoney() {
        if (nothing)
        {   money -= 20;
        }
        if (pair) {
            money += 50;
        }
        if (twoPair) {
            money += 100;
        }
        if (threeKind) {
            money += 150;
        }
        if (straight) {
            money += 200;
        }
        if (royalStraight)
        {
            money += 200;
        }
        if (flush) {
            money += 250;
        }
        if (fullHouse) {
            money += 300;
        }
        if (fourKind)
        {
            money += 400;
        }
        if (straightFlush) {
            money += 500;
        }
        if (RoyalFlush) {
            money += 1000;
        }
    }

    public void shuffle() {

        for (int i = 0; i < deck.length; i++) {
            int j = (int) (Math.random() * 52D);
            Poker.Card card = deck[i];
            deck[i] = deck[j];
            deck[j] = card;
        }
        dealButton.setEnabled(true);
        this.validate();
    }

    public Poker.Card dealCard() {

        if (++currentCard < deck.length) {
            return deck[currentCard];
        } else {
            dealButton.setEnabled(false);
            return null;
        }
    }

//  public void paint(Graphics g){
//
//      this.setBackground(Color.gray);
//      Font font = new Font("Italic", 3, 14);
//      g.setFont(font);        
//      if(pressed)
//      {          
//          Font font1 = new Font("Card", 1, 24);
//          g.setFont(font1);   
//
//          if(nothing)
//              g.drawString("You got nothing!! You lose $20 ", 50, 125);
//          if(pair)
//              g.drawString("A pair!! Win $50 ", 50, 125);
//          if(twoPair)
//              g.drawString("Two pair!! win $100 ", 50, 125);   
//          if(threeKind)
//              g.drawString("Three of a Kind!! Win $150 ", 50, 125);
//          if(straight)
//              g.drawString("A Straight!! Win $200 ", 50, 125);
//          if (royalStraight)
//              g.drawString("A Royal Straight!! Win $200 ", 50, 125);                
//          if(flush)
//              g.drawString("A Flush!! Win $250 ", 50, 125);
//          if(fullHouse)
//              g.drawString("A Full House!! Win $300 ", 50, 125);            
//          if(straightFlush)
//              g.drawString("A Straight Flush!! Win $500 ", 50, 125);
//          if(RoyalFlush)
//              g.drawString("A Royal Flush!! Win $100 ", 50, 125);            
//      }
//      
//      this.setVisible(true);
//  }

    public void changeCards(){

        System.out.println("change cards");

        firstDeal = true;
        Object obj = null;
        if(!card1State)
        {
            Poker.Card card = dealCard();
            hand[0] = card;
        }
        if(!card2State)
        {
            Poker.Card card6 = dealCard();
            hand[1] = card6;
        }
        if(!card3State)
        {
            Poker.Card card7 = dealCard();
            hand[2] = card7;
        }
        if(!card4State)
        {
            Poker.Card card8 = dealCard();
            hand[3] = card8;
        }
        if(!card5State)
        {
            Poker.Card card9 = dealCard();
            hand[4] = card9;

        }
    }

    public void evaluate() {

        int i = 0;
        if(hand[0].getSuit().equals(hand[1].getSuit()) && 
                hand[1].getSuit().equals(hand[2].getSuit()) && 
                hand[2].getSuit().equals(hand[3].getSuit()) && 
                hand[3].getSuit().equals(hand[4].getSuit()))
        {
            flush = true;
            if (flush == true)
                System.out.println("you got a a flush");
        }
        if(sort2(hand)){
            straight = true;
            if (straight = true)
                System.out.println("you got a a straight");
        }

        if(straight && flush)
        {
            straightFlush = true;
            straight = false;
            flush = false;
            System.out.println("you got a straight flush");
        }
        if(straightFlush)
        {
            for(int j = 9; j < 13; j++)
                if(hand[i].getFace().equals(faces[j]) && 
                        hand[i + 1].getFace().equals(faces[j + 1]) && 
                        hand[i + 2].getFace().equals(faces[j + 2]) && 
                        hand[i + 3].getFace().equals(faces[j + 3]) && 
                        hand[i + 4].getFace().equals(faces[j + 4]))
                {
                    straightFlush = false;
                    RoyalFlush = true;
                }

        }
        if(hand[0].getFace().equals(hand[1].getFace()) && 
                hand[0].getFace().equals(hand[2].getFace()) && 
                hand[0].getFace().equals(hand[3].getFace()) || 
                hand[1].getFace().equals(hand[2].getFace()) && 
                hand[1].getFace().equals(hand[3].getFace()) && 
                hand[1].getFace().equals(hand[4].getFace()) || 
                hand[0].getFace().equals(hand[1].getFace()) && 
                hand[0].getFace().equals(hand[3].getFace()) && 
                hand[0].getFace().equals(hand[4].getFace()) || 
                hand[0].getFace().equals(hand[2].getFace()) && 
                hand[0].getFace().equals(hand[3].getFace()) && 
                hand[0].getFace().equals(hand[4].getFace()) || 
                hand[0].getFace().equals(hand[1].getFace()) && 
                hand[0].getFace().equals(hand[2].getFace()) && 
                hand[0].getFace().equals(hand[4].getFace()))
            fourKind = true;
        else
            if(hand[0].getFace().equals(hand[1].getFace()) && 
                    hand[2].getFace().equals(hand[3].getFace()) || 
                    hand[0].getFace().equals(hand[1].getFace()) && 
                    hand[3].getFace().equals(hand[4].getFace()) || 
                    hand[1].getFace().equals(hand[2].getFace()) && 
                    hand[3].getFace().equals(hand[4].getFace()) || 
                    hand[0].getFace().equals(hand[2].getFace()) && 
                    hand[3].getFace().equals(hand[4].getFace()) || 
                    hand[0].getFace().equals(hand[1].getFace()) && 
                    hand[2].getFace().equals(hand[4].getFace()) || 
                    hand[0].getFace().equals(hand[4].getFace()) && 
                    hand[1].getFace().equals(hand[2].getFace()) || 
                    hand[0].getFace().equals(hand[3].getFace()) && 
                    hand[1].getFace().equals(hand[2].getFace()) || 
                    hand[1].getFace().equals(hand[4].getFace()) && 
                    hand[2].getFace().equals(hand[3].getFace()) || 
                    hand[0].getFace().equals(hand[3].getFace()) && 
                    hand[1].getFace().equals(hand[4].getFace()) && !fullHouse)
            {
                System.out.println("2 pair=true;");
                twoPair = true;
            } else
                if(hand[0].getFace().equals(hand[1].getFace()) && 
                        hand[1].getFace().equals(hand[2].getFace()) && 
                        hand[3].getFace().equals(hand[4].getFace()) || 
                        hand[0].getFace().equals(hand[1].getFace()) && 
                        hand[1].getFace().equals(hand[3].getFace()) && 
                        hand[2].getFace().equals(hand[4].getFace()) || 
                        hand[0].getFace().equals(hand[1].getFace()) && 
                        hand[1].getFace().equals(hand[4].getFace()) && 
                        hand[2].getFace().equals(hand[3].getFace()) || 
                        hand[0].getFace().equals(hand[3].getFace()) && 
                        hand[3].getFace().equals(hand[4].getFace()) && 
                        hand[1].getFace().equals(hand[2].getFace()) || 
                        hand[1].getFace().equals(hand[2].getFace()) && 
                        hand[2].getFace().equals(hand[4].getFace()) && 
                        hand[0].getFace().equals(hand[3].getFace()) || 
                        hand[2].getFace().equals(hand[3].getFace()) && 
                        hand[3].getFace().equals(hand[4].getFace()) && 
                        hand[0].getFace().equals(hand[1].getFace()) || 
                        hand[1].getFace().equals(hand[2].getFace()) && 
                        hand[2].getFace().equals(hand[3].getFace()) && 
                        hand[0].getFace().equals(hand[4].getFace()) && !straightFlush){        
                    fullHouse = true;

                }
        if((hand[0].getFace().equals(hand[1].getFace()) && 
                hand[1].getFace().equals(hand[2].getFace()) || 
                hand[0].getFace().equals(hand[2].getFace()) && 
                hand[0].getFace().equals(hand[4].getFace()) || 
                hand[0].getFace().equals(hand[2].getFace()) && 
                hand[0].getFace().equals(hand[3].getFace()) || 
                hand[1].getFace().equals(hand[3].getFace()) && 
                hand[1].getFace().equals(hand[4].getFace()) || 
                hand[0].getFace().equals(hand[1].getFace()) && 
                hand[1].getFace().equals(hand[3].getFace()) || 
                hand[0].getFace().equals(hand[1].getFace()) &&
                hand[1].getFace().equals(hand[4].getFace()) || 
                hand[1].getFace().equals(hand[2].getFace()) && 
                hand[2].getFace().equals(hand[4].getFace()) || 
                hand[2].getFace().equals(hand[3].getFace()) &&
                hand[3].getFace().equals(hand[4].getFace()) || 
                hand[1].getFace().equals(hand[2].getFace()) &&
                hand[2].getFace().equals(hand[3].getFace())) && 
                !twoPair && !fullHouse && !fourKind){
            threeKind = true;


        }
        else
            if((hand[i].getFace().equals(hand[i + 1].getFace()) || 
                    hand[i].getFace().equals(hand[i + 2].getFace()) ||
                    hand[i].getFace().equals(hand[i + 3].getFace()) ||
                    hand[i].getFace().equals(hand[i + 4].getFace()) ||
                    hand[i + 1].getFace().equals(hand[i + 2].getFace()) ||
                    hand[i + 1].getFace().equals(hand[i + 3].getFace()) || 
                    hand[i + 1].getFace().equals(hand[i + 4].getFace()) || 
                    hand[i + 2].getFace().equals(hand[i + 3].getFace()) || 
                    hand[i + 2].getFace().equals(hand[i + 4].getFace()) ||
                    hand[i + 3].getFace().equals(hand[4].getFace())) && 
                    !twoPair && !threeKind && !fullHouse){
                pair = true;

            }

            else
            {   nothing = true;
            System.out.println("you got nothing");
            }
        this.validate();
        // giveMoney();
    }

    public int getFaceValue2( Poker.Card card) {
        String s = card.getFace();
        byte byte0 = 0;
        if(s.equals(faces[0]))
            byte0 = 2;
        if(s.equals(faces[1]))
            byte0 = 3;
        if(s.equals(faces[2]))
            byte0 = 4;
        if(s.equals(faces[3]))
            byte0 = 5;
        if(s.equals(faces[4]))
            byte0 = 6;
        if(s.equals(faces[5]))
            byte0 = 7;
        if(s.equals(faces[6]))
            byte0 = 8;
        if(s.equals(faces[7]))
            byte0 = 9;
        if(s.equals(faces[8]))
            byte0 = 10;
        if(s.equals(faces[9]))
            byte0 = 11;
        if(s.equals(faces[10]))
            byte0 = 12;
        if(s.equals(faces[11]))
            byte0 = 13;
        if(s.equals(faces[12]))
            byte0 = 14;
        return byte0;
    }

    public boolean sort2( Poker.Card acard[]){
        boolean flag = false;
        int ai[] = new int[5];
        for(int i = 0; i < 5; i++)
            ai[i] = getFaceValue2(acard[i]);

        for(int k = 1; k < ai.length; k++)
        {
            for(int l = 0; l < ai.length - 1; l++)
                if(ai[l] > ai[l + 1])
                {
                    int j = ai[l];
                    ai[l] = ai[l + 1];
                    ai[l + 1] = j;
                }

        }

        for(int i1 = 0; i1 < ai.length - 1; i1++)
            if(ai[0] + 1 == ai[1] && ai[1] + 1 == ai[2] && ai[2] + 1 == 
            ai[3] && ai[3] + 1 == ai[4])
                flag = true;
            else
                flag = false;

        if(flag)
            System.out.print(hand[0] + " " + hand[1] + " " + hand[2] + " " + 
                    hand[3] + " " + hand[4]);
        System.out.print(ai[0] + " " + ai[1] + " " + ai[2] + " " + ai[3] +
                " " + ai[4]);
        return flag;
    }
}