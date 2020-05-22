enum Direction {
    NORTH() {
        public Direction getOppositeDirection() {
            return SOUTH;
        }
    },
    EAST() {
        public Direction getOppositeDirection() {
            return WEST;
        }
    },
    SOUTH() {
        public Direction getOppositeDirection() {
            return NORTH;
        }
    },
    WEST() {
        public Direction getOppositeDirection() {
            return EAST;
        }
    };

    public abstract Direction getOppositeDirection();
}