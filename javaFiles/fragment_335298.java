class RootObj {
    D d;
}

class D {
    List<Result> results;
}

class Result {
    @SerializedName("Accountnum")
    public String accountnumStr;

    @SerializedName("name")
    public String nameStr; 
}