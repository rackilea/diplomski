boolean subsequentElementsSelected = false;
for(int i = clientListpost.length -1; i >= 0; i--){
  if(clientpost[i]) { //or clientpost[i] == true
    if(subsequentElementsSelected ) { 
      clientString[i] = client[i] + ",";
    } else {
      //only true for the last element to be added/set
      clientString[i] = client[i];
    }

    //once we've added an element at the end this will stay true
    subsequentElementsSelected  = true;
  } 
}