final ThreadLocal<Boolean> isLast = new ThreadLocal<Boolean>() {
        public Boolean initialValue() {
            return false;
        }
    };
    final Phaser p = new Phaser(9) {
        public boolean onAdvance(int phase, int registeredParties) {
            isLast.set(true);
            return true;
        }
    };