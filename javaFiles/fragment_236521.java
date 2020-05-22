enum Dirs {

    NORTH {
        @Override
        public Dirs getOppositeDirection() {
            return SOUTH;
        }
    }, 
    SOUTH {
        @Override
        public Dirs getOppositeDirection() {
            return NORTH;
        }
    };

    public abstract Dirs getOppositeDirection();
}