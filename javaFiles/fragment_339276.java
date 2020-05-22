class Sample implements java.io.Serializable{

    //POJO with two fields and getters/setters

    private String name;
    private Integer id;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    //This POJO does not override equals() and hashCode()
}

public class Beta /*implements Comparable*/{
    private Sample sample;

    public Sample getSample() {
        return sample;
    }

    public void setSample(Sample sample) {
        this.sample = sample;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Beta other = (Beta) obj;

        if ((this.getSample() == null) && (other.getSample() == null)){
            return true;
        }
        if ((this.getSample().getId().equals(other.getSample().getId())) && (this.getSample().getName().equals(other.getSample().getName()))) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (this.getSample().getName() != null ? this.getSample().getName().hashCode() : 0);
        hash = 53 * hash + (this.getSample().getId() != null ? this.getSample().getId().hashCode() : 0);
        return hash;
    }


/*  @Override
    public int compareTo(Object o) {

        if(!(o instanceof Beta)){
            return -1;
        }
        if(((Beta)o).getSample().getId().equals(this.sample.getId()) && ((Beta)o).getSample().getName().equals(this.sample.getName())){
            return 0;
        }
        return -1;
    }*/

    public static void main(String[] args) {
        Beta b = new Beta();
        Sample s = new Sample();
        s.setId(10);
        s.setName("Name1");
        b.setSample(s);

        Beta b2 = new Beta();
        Sample s2 = new Sample();
        s2.setId(20);
        s2.setName("Name2");
        b2.setSample(s2);

        System.out.println(b2.equals(b));

        Beta b3 = new Beta();
        Sample s3 = new Sample();
        s3.setId(10);
        s3.setName("Name1");
        b3.setSample(s3);

        System.out.println(b3.equals(b));
    }