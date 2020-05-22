public class CommonEquals implements EqualsCriteria {
    private String name;
    private String surname;


    @Override
    public boolean isEqual(EqualsCriteria other) {
     if(other==null) return false;
     return Arrays.asList(getParam()).equals(Arrays.asList(other.getParam()));
    }

    }