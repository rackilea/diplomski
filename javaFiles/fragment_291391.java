import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Walk {
    enum Move {
        L   (-1, 0)
        , U (0, 1)
        , R (1, 0)
        , D (0, -1)
        , X (0, 0)
        ;
        private int dx;
        private int dy;
        private Move(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }
        public int getDx() {
            return dx;
        }
        public int getDy() {
            return dy;
        }

    }

    public static void main(String[] args) {
        String input = "3L5UR2DDX2LR";
        String regex = "(?<factor>\\d*)"
                + "(?<dir>[LURDX])";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);
        int x = 0;
        int y = 0;
        int lastX = 0;
        int lastY = 0;
        while (m.find()) {
            String factorString = m.group("factor");
            int factor;
            if (factorString.length()==0) {
                factor=1;
            } else {
                factor=Integer.parseInt(factorString);
            }
            String dirString    = m.group("dir");
            Move move = Move.valueOf(dirString);
            System.out.format("(%d,%d) last was (%d, %d) %d %s -> "
                    , x, y
                    , lastX, lastY
                    , factor, move.name());
            if (move==Move.X) {
                x = lastX;
                y = lastY;
            } else {
                lastX = x;
                lastY = y;
                x += factor * move.getDx();
                y += factor * move.getDy();
            }           
            System.out.format("(%d,%d)%n", x, y);
        }
        System.out.format("finally arrive at (%d,%d)%n", x, y);

    }

}