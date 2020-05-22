public class Student extends Person {

    private float[] p;
    private int id;

    public Student (String name, String fname) {
        this (name, fname, -1, null);
    }

    public Student (String name, String fname, int id, float[] p) {
        super (name, fname);
        this.id = id;
        this.p = p;
    } 

    public void setP (float[] p) {
        this.p = p;
    }

    public float[] getP () {
        return p;
    }

    public void setId (int id) {
        this.id = id;
    }

    public int getId () {
        return id;
    }

    public float summation () {
        float sum = 0;
        for (int i = 0; i < p.length; i++)
            sum += p[i];
        return sum;
    }

    public float miangin () {
        return summation () / 4.0f;
    }

    @Override
    public String toString () {
        return new StringBuilder ()
            .append ("Name: ").append (name)
            .append (" Family name: ").append (fname)
            .append (" Id: ").append (id)
            .append (" min: ").append (miangin ())
            .toString ();
    }

}