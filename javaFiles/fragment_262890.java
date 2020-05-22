public class TREE {

    public static int PLAYER() {
        return PLAYER.VALUE;
    }

    public final static class PLAYER {
        private PLAYER() {
        }

        public final static int VALUE = 1;
        public final static String NAME = "Player";
    }

    public static void main(String[] args) {
        System.out.println(TREE.PLAYER());
        System.out.println(TREE.PLAYER.NAME);
    }
}