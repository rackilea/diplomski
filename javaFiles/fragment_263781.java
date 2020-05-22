public final class CursorAndCount {
    private final int count;
    private final Cursor cursor;

    public CursorAndCount(int count, Cursor cursor) {
        this.count = count;
        this.cursor = cursor;
    }

    public int getCount() {
        return count;
    }

    public int getCursor() {
        return cursor;
    }
}