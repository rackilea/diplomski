public enum King {
    ELVIS, // error, default constructor is not defined
    MICHAEL_JACKSON(true)
    ;
    private boolean kingOfPop;
    King(boolean kingOfPop){this.kingOfPop = kingOfPop;}
}