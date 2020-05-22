enum BlockSort implements Comparator<Block> {
    XSORT {
        @Override
        public int compare(Block b1, Block b2) {
            return b1.x - b2.x;
        }
    },

    YSORT {
        @Override
        public int compare(Block b1, Block b2) {
            return b1.y - b2.y;
        }
    }
}