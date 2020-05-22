@Override
public int getColumnCount() {
    return 5;
}

...

@Override
public Object getValueAt(int rowIndex, int columnIndex) {
    Game game = games.get(rowIndex);
    switch (columnIndex) {
        case 0:
            return game.getId();
        case 1:
            return game.getTitle();
        case 2:
            return game.getPublisher();
        case 3:
            return game.getGenre();
        case 4:
            return game.getReleaseDate();
    }
    return null;
}