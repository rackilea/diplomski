public class Article {

    LocalDate startDateValidity;
    LocalDate endDateValidity;

    // Note that this constructor accepts string arguments for convenience
    public Article(String startValidity, String endValidity) {
        this.startDateValidity = LocalDate.parse(startValidity);
        this.endDateValidity = LocalDate.parse(endValidity);
    }

    // getters etc.

}