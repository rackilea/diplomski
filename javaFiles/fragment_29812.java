static class PieceModel {
    private int position;
    private int piece_id;

    public PieceModel(int position, int piece_id) {
        this.position = position;
        this.piece_id = piece_id;
    }

    @Override
    public String toString() {
        return "{" +
                "position=" + position +
                ", piece_id=" + piece_id +
                '}';
    }
}

public static void main(String[] args) {
    List<PieceModel> list = new ArrayList<>();
    list.add(new PieceModel(1, 100));
    list.add(new PieceModel(2, 300));
    list.add(new PieceModel(3, 600));
    System.out.print(list.toString());
}