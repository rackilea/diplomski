public class Practise {
static enum SHIFT {
    BREAKFAST, LUNCH, DINNER
}

public static void main(String[] args) {
    SHIFT key = SHIFT.BREAKFAST; // hardcoded for example, but can be dynamic
    switch (key) {
    case BREAKFAST:

        break;

    default:
        break;
    }
}