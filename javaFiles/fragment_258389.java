public class ResponseClass {

public boolean isResult() {
    return result;
}

public void setResult(boolean result) {
    this.result = result;
}


@SerializedName("IsSuccess")
private boolean result;

public String getError() {
    return Error;
}

public void setError(String error) {
    Error = error;
}

public String getHeader() {
    return Header;
}

public void setHeader(String header) {
    Header = header;
}

@SerializedName("Error")
private String Error;


@SerializedName("Header")
private String Header;


public ArrayList<SpinnerModalClass> getSpinnerModalClassArrayList() {
    return spinnerModalClassArrayList;
}

public void setSpinnerModalClassArrayList(ArrayList<SpinnerModalClass> couponsListingModalArrayList) {
    this.spinnerModalClassArrayList = couponsListingModalArrayList;
}

@SerializedName("Data")
private ArrayList<SpinnerModalClass> spinnerModalClassArrayList;

public class SpinnerModalClass {
    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    @SerializedName("Title")
    private String Title;

    @SerializedName("Id")
    private String Id;



}