public Test() {
    new Anonymous1() {
        void validate() {
            final Object this1 = this;
            new Anonymous2() {
                int calculate() {
                    return Math.abs(this1.getValue()); 
                }
            }
        }
    }
}