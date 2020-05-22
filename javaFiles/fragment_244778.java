HyperTextCell hyperTextCell = new HyperTextCell();
    Column<ServerKeyWord, ServerKeyWord> hyperColumn = new Column<ServerKeyWord, ServerKeyWord>(
            hyperTextCell) {

        @Override
        public ServerKeyWord getValue(ServerKeyWord keyWord) {
            return keyWord;
        }
    };
    myCellTable.addColumn(hyperColumn);