public class Sample {
    ResultSet rs; // is null
    public method() {
        ResultSet rs = stmt.execute(); // here the other rs is hidden
    }
}