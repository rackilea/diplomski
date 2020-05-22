import java.time.Month;  // Enum use in `switch` statement.

public int getPrice() {
    LocalDateTime now = LocalDateTime.now();   // line 2
    switch (now.getMonth()) {                  // line 3
        case AUGUST:
            return 30;
        case SEPTEMBER:
            return 40;
        case OCTOBER:
            return 50;
        default:
            return 0;
    }
}
// line 2&3 can be reduce in : // switch (LocalDateTime.now().getMonth()){