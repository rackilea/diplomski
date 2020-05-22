public class Filter {

    @SerializedName("Decription") // This requires same as your Json key 
    public String description;
    @SerializedName("FieldSelected") // The Json Object of FieldSelected
    public Field listDetails;

}

public class Field {
    @SerializedName("ptStatusOrder")
    public int status;
    @SerializedName("AppointmentDateOrder")
    public int dateOrder;
    @SerializedName("AppointmentDate")
    public boolean appDate;
}