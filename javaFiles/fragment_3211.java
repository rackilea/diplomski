// Genre is json array
JSONArray companydept = obj.getJSONArray("companyDepartments");
ArrayList<String> departments = new ArrayList<String>();
for (int j = 0; j < companydept.length(); j++) {
     departments.add((String) companydept.get(j));
}

Company company = new Company(obj.getInt("companyID"),
                              obj.getString("comapnyName"),
                              obj.getString("companyOwner"),
                              obj.getString("companyStartDate"),
                              obj.getString("companyDescription"),
                              departments); // <--- Pass the ArrayList here