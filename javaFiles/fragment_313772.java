enum CoffeSize {
    BIG(8),
    HUGE(10),
    OVERWHELMING(20) {
        public String getLidCode() {
            return "B";
        }
    };
    // rest of enum code here
}