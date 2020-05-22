public class Results {
    @SerializedName("Result")
    List<Result> results;
}

public class Result {
    String title;
    Map<String, Integer> results;
}