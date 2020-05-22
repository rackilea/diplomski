public Company(int companyid,String companyname, 
               String companyowner, String startdate, 
               String description, JSONArray companydept) {
     this.companyid=companyid;
     this.companyname = companyname;
     this.companyowner = companyowner;
     this.startdate = startdate;
     this.description = description;

    // build it in the constructor here:
    this.departments = new ArrayList<String>();
    for (int j = 0; j < companydept.length(); j++) {
         departments.add((String) companydept.get(j));
    }  
}