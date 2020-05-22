abstract class KingA<J extends JokerA, Q extends QueenA<J>> {
    KingA(Q.Princess princess) {
        Gift giftForPrincess = new Gift();
        princess.receiveGift(giftForPrincess);
    }
}

abstract class KingB<J extends JokerB, Q extends QueenB<J>> extends KingA<J, Q> {
    KingB(Q.Princess princess) {
        super(princess);
    }
}