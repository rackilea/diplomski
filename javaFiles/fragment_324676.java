use strum_macros::EnumIter; // etc.
use strum::IntoEnumIterator;
use rand::thread_rng;
use rand::seq::SliceRandom;

#[derive(Debug, Copy, Clone,EnumIter)]
enum Suit {
    DIAMONDS,
    HEARTS,
    CLUBS,
    SPADES,
}

#[derive(Debug, Copy, Clone, EnumIter)]
enum Rank {
    Ace,
    King,
    Queen,
    Jack,
}

#[derive(Debug)]
struct Card {
    suit: Suit,
    rank: Rank,
}

impl Card {
    fn new(suit: Suit, rank: Rank) -> Card {
        Card { suit, rank }
    }
}

fn main() {
    let mut cards = Vec::<Card>::new();

    for r in Rank::iter() {
        for s in Suit::iter() {
            cards.push(Card::new(s, r));
        }
    }

    let mut rng = thread_rng();
    cards.shuffle(&mut rng);

    println!("{:?}", cards);
}