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

public class Beta implements Comparable{
    private Sample sample;

    public Sample getSample() {
        return sample;
    }

    public void setSample(Sample sample) {
        this.sample = sample;
    }

    @Override
    public int compareTo(Object o) {

        if(!(o instanceof Beta)){
            return -1;
        }
        }if(((Beta)o).getSample().getName().equals(this.sample.getName())){
                return 0; // return true if names are equal
            }
            if(((Beta)o).getSample().getId().equals(this.sample.getId())){
            //if name are notequal and IDs are equal, do what you need to do
            }
        return -1;
    }

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

        System.out.println(b2.compareTo(b));

        Beta b3 = new Beta();
        Sample s3 = new Sample();
        s3.setId(10);
        s3.setName("Name1");
        b3.setSample(s3);

        System.out.println(b3.compareTo(b));
    }
}