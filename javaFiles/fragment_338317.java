public Test() {
    new Anonymous1() {
        void validate() {
            int value = getValue();
            new Anonymous2() {
                int calculate() {
                    return Math.abs(value); 
                }
            }
        }
    }
}