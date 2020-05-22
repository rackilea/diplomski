public class GFragment extends Fragment{
  private String json;
  private final String KEY_JSON = "json";
  //..rest of variables
} 

protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    outState.putString(KEY_JSON, user);

}

@Nullable
@Override
public View onCreateView(@NonNull LayoutInflater inflater, @Nullable 
  ViewGroup container, @Nullable final Bundle savedInstanceState) { 
     if (savedInstanceState != null) {
       json = savedInstanceState.getString(KEY_JSON);

    } else {
       json = ""
    }
    //...rest of onCreateView()

   if (!TextUtils.isEmpty(json) {
        parseJSON();
   }

  }

private void parseJSON() {
   try {
     JSONArray products = new JSONArray(response);
     for (int i = 0; i < products .length(); i++) {
         JSONObject productObject = products.getJSONObject(i);
         //storing the variables from database
         String id = productObject.getString("product_id");
         String title= 
         productObject.getString("product_title");
         Product product= new Product(id);
         productList.add(product);
      }
      adapter = new productAdapter(getActivity(), productList);
      recyclerView.setAdapter(adapter);
          //..any other parsing
      }
      catch (JSONException e) {
         e.printStackTrace();
      }
  }