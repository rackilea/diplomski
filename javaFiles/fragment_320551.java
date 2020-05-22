class Tile extends Actor {
        int row, column; //and others

        public Tile() {}

        public Tile(Tile tile) {
            this();

            //now copying another tile's values
            this.row = tile.row;
            this.column = tile.column;
        }
    }