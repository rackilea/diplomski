@Data // comes from lombok
class RootClass {
    @SerializedName("data")
    private List<Data> datas;
    private Pagination pagination;
}

@Data
class Pagination {
    private String cursor;
}

@Data
class Data {
    // your current implementation without pagination field
}