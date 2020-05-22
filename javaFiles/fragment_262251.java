public class GeoTotalByCountry {

    int id;
    String Country;
    String Total;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getTotal() {
        return Total;
    }

    public void setTotal(String total) {
        Total = total;
    }


    @Override
    public String toString() {
        return String.valueOf(Total);
    }
}