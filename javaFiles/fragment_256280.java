// Considering your response consists of json objects & json array
// Create a POJO class for your response with the link above

{
"keyOne": 1,
"keyTwo": "Some Value",
"someArray": [{
        "key": "Value"
    },
    {
        "key": "Value"
    }
]
}



 import java.util.List;
 import com.google.gson.annotations.Expose;
 import com.google.gson.annotations.SerializedName;

 public class ExampleClass {

   @SerializedName("keyOne")
   @Expose
   private int keyOne;
   @SerializedName("keyTwo")
   @Expose
   private String keyTwo;
   @SerializedName("someArray")
   @Expose
   private List<SomeArray> someArray = null;

   public int getKeyOne() {
   return keyOne;
   }

   public void setKeyOne(int keyOne) {
   this.keyOne = keyOne;
   }

   public String getKeyTwo() {
   return keyTwo;
   }

   public void setKeyTwo(String keyTwo) {
   this.keyTwo = keyTwo;
   }

   public List<SomeArray> getSomeArray() {
   return someArray;
   }

  public void setSomeArray(List<SomeArray> someArray) {
  this.someArray = someArray;
   }

  }

  // Parsing JSON response with GSON
  GsonBuilder gsonBuilder = new GsonBuilder();
  Gson gson = gsonBuilder.create();
  ExampleClass resultObj = gson.fromJson(jsonObject.toString(), ExampleClass.class);
  int keyOneValue = resultObj.getKeyOne() // First JSON Object 
  // Getting String value
  String keyTwoValue = resultObj.getKeyTwo() // Second JSON Object 
  List<SomeArray> yourJSONArray = resultObj.getSomeArray() // Getting JSON Array contents