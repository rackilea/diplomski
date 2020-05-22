public class JuniorArea {
    private String juniorAreaDescription;
    private List<MerchandisingGroup> mechandisingGroup;

    public String getJuniorAreaDescription() {
        return juniorAreaDescription;
    }
    public void setJuniorAreaDescription(String juniorAreaDescription) {
        this.juniorAreaDescription = juniorAreaDescription;
    }
    public List<MerchandisingGroup> getMechandisingGroup() {
        return mechandisingGroup;
    }
    public void setMechandisingGroup(List<MerchandisingGroup> mechandisingGroup) {
        this.mechandisingGroup = mechandisingGroup;
    }

    @Override
    public String toString() {
        return "JuniorArea [juniorAreaDescription=" + juniorAreaDescription + ", mechandisingGroup=" + mechandisingGroup
                + "]";
    }
}