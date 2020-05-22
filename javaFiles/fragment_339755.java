public class Sample {
    ResultSet rs;
    public method() {
        this.rs = stmt.execute(); // there is no declaration here, so rs is the field
                                  // and not a new, local variable
    }
}