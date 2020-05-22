public String title_value = "";

public TaxiInfoWindowAdapter(Activity act){
    if(Holder.myValue != null)
        title_value = Holder.myValue.toString();
    if(title_value.equals("Taxi")){
        // Rest of the code