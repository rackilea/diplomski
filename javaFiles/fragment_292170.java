import com.google.gson.Gson;

public class MyObject extends SugarRecord implements Parcelable {
    public String myString;
    @Ignore //Sugar will ignore this field. 
    private List<String> myStringList;  //Change to private (accessed via getter/setter method)
    private String myStringListStore; //to store the list in JSON format. 

    public MyObject () { }

    private MyObject (Parcel in) {
        this.myString= in.readString();
        this.myStringList= new ArrayList<>(); 
        in.readList(myStringList, String.class.getClassLoader());
    }

    public static final Creator<MyObject> CREATOR = new Creator<MyObject>(){
        public MyObjectcreateFromParcel(Parcel in) { return new MyObject(in); }
        public MyObject[] newArray(int size) { return new MyObject[size]; }
    };

    public List<String> getMyStringList(){
        //Convert from JSON string to List
       myStringList =  new Gson().fromJson(this.myStringListStore,new TypeToken<List<String>>(){}.getType());
       return myStringList;
    }

    public setMyStringList(List<String> stringList){
        this.myStringList = stringList;
    }

    //Override save to ensure the list is converted into JSON before saving. 
    @Override
    public long save(){
        this.myStringListStore = new Gson().toJson(stringList); 
        return super.save();
    }

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(myString);
        dest.writeList(getMyStringList());
    }
}