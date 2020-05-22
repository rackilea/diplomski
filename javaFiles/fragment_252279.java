public class GetCoffeeBrandsAndSaveToDB implements AsyncResponse {

    private Gson gson = new Gson();
    DatabaseHandler dbh;
    Context context;

    public GetCoffeeBrandsAndSaveToDB(Context context) {
        this.context = context;
        dbh = new DatabaseHandler(context);
    }

    public void getAllCoffeeBrands(){
        GetAllBrands g = new GetAllBrands("http://192.168.2.105:3000/api/", this);
        g.execute();
    }