public String symptomsToJSON() {
 String allSymptoms = "";
 if(getSymptoms() != null)   {
  for (int i = 0; i < symptoms.length; i++) {
      if (i == 0)
          allSymptoms += symptoms[i].toJSON();
      //NOTE: Without this,  the preceding line gets printed twice for i==0
      else 
          allSymptoms += "," + symptoms[i].toJSON();
    } 
 }
 return allSymptoms; 
}