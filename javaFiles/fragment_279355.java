class Destination {

    private String city;

    public Destination() {
        // TODO Auto-generated constructor stub
    }

    public Destination(String city) {
        super();
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Destination that = (Destination) o;

        if (city != null ? !city.equals(that.city) : that.city != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return city != null ? city.hashCode() : 0;
    }
}