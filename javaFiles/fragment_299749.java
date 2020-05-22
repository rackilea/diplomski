package ElevensLab;
import java.util.List;
import java.util.ArrayList;

public class Deck {
    private List<Card> cards;
    private int size;
    public Deck(String[] suits, String[] ranks, int[] values){
        ArrayList<Card> cards=new ArrayList<Card>();
        for(String suit: suits){
            for(String rank: ranks){
                for(int value: values){
                    cards.add(new Card(rank, suit, value)); //This is the line I changed
                }
            }
        }
        size=cards.size();
    }