import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class SimpleCards {

    public static void main(String[] args) {
        new SimpleCards();
    }

    public SimpleCards() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                Deck.INSTANCE.shuffle();
                List<Hand> players = new ArrayList<>(5);
                for (int index = 0; index < 5; index++) {
                    players.add(new Hand());
                }

                for (int index = 0; index < 5; index++) {
                    for (Hand hand : players) {
                        hand.add(Deck.INSTANCE.pop());
                    }
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new GamePane(players));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class Hand {

        private List<Card> cards;

        public Hand() {
            cards = new ArrayList<>(25);
        }

        public void add(Card card) {
            cards.add(card);
        }

        public int size() {
            return cards.size();
        }

        public Iterable<Card> cards() {
            return cards;
        }

        public Iterable<Card> reveresed() {
            List<Card> reversed = new ArrayList<>(cards);
            Collections.reverse(reversed);
            return reversed;
        }
    }

    public static class Card {

        private Suit suit;
        private Face face;

        public Card(Suit suit, Face face) {
            this.suit = suit;
            this.face = face;
        }

        public Suit getSuit() {
            return suit;
        }

        public Face getFace() {
            return face;
        }

    }

    public enum Deck {

        INSTANCE;

        private List<Card> cards;
        private List<Card> playDeck;

        private Deck() {
            cards = new ArrayList<>(52);
            for (Suit suit : Suit.items) {
                for (Face face : Face.items) {
                    cards.add(new Card(suit, face));
                }
            }
            playDeck = new ArrayList<>(cards);
        }

        public void shuffle() {
            playDeck.clear();
            playDeck.addAll(cards);
            Collections.shuffle(playDeck);
        }

        public Card pop() {
            if (playDeck.isEmpty()) {
                return null;
            }
            return playDeck.remove(0);
        }

        public void push(Card card) {
            playDeck.add(card);
        }

    }

    enum Face {
        ONE("1"), TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6"), SEVEN("7"), EIGHT("8"), NINE("9"), JACK("J"), QUEEN("Q"), KING("K");

        private String value;

        private Face(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        private static Face[] items = new Face[]{
            ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, JACK, QUEEN, KING
        };
    }

    enum Suit {
        CLUBS("♣"), DIAMONDS("♦"), HEARTS("♥"), SPADES("♠");

        private String value;

        private Suit(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public static Suit[] items = new Suit[]{
            CLUBS, DIAMONDS, HEARTS, SPADES
        };
    }

    public class GamePane extends JPanel {

        private List<Hand> players;

        private Map<Card, Rectangle> mapCards;

        private Card selected;

        public GamePane(List<Hand> players) {
            this.players = players;
            mapCards = new HashMap<>(players.size() * 5);

            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (selected != null) {
                        Rectangle bounds = mapCards.get(selected);
                        bounds.y += 20;
                        repaint();
                    }
                    selected = null;
                    // This is done backwards, as the last card is on
                    // top.  Of course you could render the cards
                    // in reverse order, but you get the idea
                    for (Card card : players.get(0).reveresed()) {
                        Rectangle bounds = mapCards.get(card);
                        if (bounds.contains(e.getPoint())) {
                            selected = card;
                            bounds.y -= 20;
                            repaint();
                            break;
                        }
                    }
                }
            });
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 400);
        }

        @Override
        public void invalidate() {
            super.invalidate();
            mapCards.clear();
            Hand hand = players.get(0);
            int cardHeight = (getHeight() - 20) / 3;
            int cardWidth = (int) (cardHeight * 0.6);
            int xDelta = cardWidth / 2;
            int xPos = (int) ((getWidth() / 2) - (cardWidth * (hand.size() / 4.0)));
            int yPos = (getHeight() - 20) - cardHeight;
            for (Card card : hand.cards()) {
                Rectangle bounds = new Rectangle(xPos, yPos, cardWidth, cardHeight);
                mapCards.put(card, bounds);
                xPos += xDelta;
            }
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            Hand hand = players.get(0);
            for (Card card : hand.cards) {
                Rectangle bounds = mapCards.get(card);
                System.out.println(bounds);
                if (bounds != null) {
                    g2d.setColor(Color.WHITE);
                    g2d.fill(bounds);
                    g2d.setColor(Color.BLACK);
                    g2d.draw(bounds);
                    Graphics2D copy = (Graphics2D) g2d.create();
                    paintCard(copy, card, bounds);
                    copy.dispose();
                }
            }
            g2d.dispose();
        }

        protected void paintCard(Graphics2D g2d, Card card, Rectangle bounds) {
            g2d.translate(bounds.x + 5, bounds.y + 5);
            g2d.setClip(0, 0, bounds.width - 5, bounds.height - 5);

            String text = card.getFace().getValue() + card.getSuit().getValue();
            FontMetrics fm = g2d.getFontMetrics();

            g2d.drawString(text, 0, fm.getAscent());
        }
    }

}