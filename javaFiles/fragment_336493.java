JSONArray result_array= new JSONArray(string_result);
JSONArray internal_array;
JSONObject object;
ResultType temp;

for(int i=0;i<result_array.size();i++){//scan the main array
    internal_array  new JSONArray(result_array.get(i)); //get the i array

    for(int k=0;k<internal_array.size();k++){ //scan the i intern array(with always one element)
          object = new JSONObject(internal_array.get(k));
          temp = new ResultType();
          temp.setId(object.getString("id"));
          temp.setId(object.getString("phone"));
          .
          .
          all.add(temp);
    }
}