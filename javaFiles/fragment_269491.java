StringBuilder builder = new StringBuilder();
for(int i = 0; i <= clientListpost.length -1; i++){
  if(clientpost[i]) { //or clientpost[i] == true

    //if there's already something in the String, add a comma first
    if(builder.length() > 0) { 
      builder.append(",");
    } 

    //add the element
    builder.append(client[i]);
  } 
}
clientUrl += builder.toString(); //assumes there's more in clientUrl, otherwise just assign