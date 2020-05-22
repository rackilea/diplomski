public abstract class Binding {
    public abstract void bind(PreparedStatement ps) throws SQLException;
}

public class IntegerBinding extends Binding {
    private int value;
    private int index;

    public IntegerBinding(int _index, int _value) {
        index = _index;
        value = _value;
    }

    public void bind(PreparedStatement ps) throws SQLException {
        ps.setInt(index, value);
    }
}