public class Pojo {

private String catagory_id;
private String catagory_name;
private String catagory_thumbnailUrl;
private ArrayList<SubCatagory> subCatagoryArrayList;

public ArrayList<SubCatagory> getSubCatagoryArrayList() {
    return subCatagoryArrayList;
}

public void setSubCatagoryArrayList(ArrayList<SubCatagory> subCatagoryArrayList) {
    this.subCatagoryArrayList = subCatagoryArrayList;
}

public String getCatagory_id() {
    return catagory_id;
}

public void setCatagory_id(String catagory_id) {
    this.catagory_id = catagory_id;
}

public String getCatagory_name() {
    return catagory_name;
}

public void setCatagory_name(String catagory_name) {
    this.catagory_name = catagory_name;
}

public String getCatagory_thumbnailUrl() {
    return catagory_thumbnailUrl;
}

public void setCatagory_thumbnailUrl(String catagory_thumbnailUrl) {
    this.catagory_thumbnailUrl = catagory_thumbnailUrl;
}
}