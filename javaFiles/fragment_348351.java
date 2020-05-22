public class Individual {
    private String name;
    private String city;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Name of Individual :").append(this.getName())
                .append("\nCity :").append(this.getCity());
        return builder.toString();
    }
    public static void main(String[] args) {
        Individual individual = new Individual();
        individual.setName("Crucified Soul");
        individual.setCity("City of Crucified Soul");
        System.out.println(individual);
    }
}