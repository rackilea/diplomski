package tt.tt;

import java.io.Serializable;

public class Format implements Serializable {
    private static final long serialVersionUID = 1L;
    public String name;
    public long points;
    public int position;

    @Override
    public String toString() {
        return new StringBuilder().append(Integer.toString(position)).append("    ").append(name).append("     ").append(points).toString();
    }
}