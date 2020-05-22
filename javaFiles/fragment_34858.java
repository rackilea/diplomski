public enum BallCounts {

        LEVEL1(5), LEVEL2(10);//add other levels

        private int level;

        private BallCounts(int count) {
            this.level = level;
        }

        //Single getter method
        public int getBallCountLevel() {
            return level;
        }
    }