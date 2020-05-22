private ArrayList<Employee> employeeDetails=new ArrayList();/*ArrayList that holds the list data that are to be populated in a listview.*/

        try{
        JSONObject jObj=new JSONObject(jsonString);
        JSONArray jArrray=jObj.getJSONArray("items");
        for(int i=0;i<jArray.length();i++){
        Employee mEmployee=new Employee();
        JSONObject empDetails=jArray.getJSONObject(i);
        String empName=empDetails.getString("name");
        String entryTime=empDetails.getString("entryTime");
        String exitTime=empDetails.getString("exitTime);
String date=empDetails.getString("date");

        mEmployee.setEmployeeName(empName);
        mEmployee.setEntryTime(entryTime);
        mEmployee.setExitTime(exitTime);
        mEmployee.setDate(date);
        employeeDetails.add(mEmployee);/*add data to arraylist*/

        }
    }catch(JSONException e){
    e.printStacktrace();
    }