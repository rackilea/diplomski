public class SampleVO1 {
    protected NameVO nameVo = new NameVO();

    public String getFirstName() {
        return nameVo.getFirstName();
    }

    public void setFirstName(String firstName) {
        this.nameVo.setFirstName(firstName);
    }

    // etc.
}