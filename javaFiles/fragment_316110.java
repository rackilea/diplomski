public class X {
    private Date y = new Date();

    // other code here

    public Date getY() {
        //this could be bad:
        //return y;
        //this is good:
        return new Date(y);
    }