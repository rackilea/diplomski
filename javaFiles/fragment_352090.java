if(!"".equals(row[11])){ //If row[11] is not an empty string
    s.setPrimaryProviderId(Integer.parseInt(row[11]));
}
else{
    // Handle the case where this part of the data is empty
}