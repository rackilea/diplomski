String amount = "No amount found";
boolean isGroup=false;
while(line = br.readline() != null) {
    // Check all your conditions to see if this is the line you care about
    if(isGroup){
      amount = line;
      isGroup = false; // so you only capture this once
      continue;
    }
    else if (isOtherCondition) {
      // handle other condition;
      isOtherCondition = false; // so you only capture this once
      continue;
    }

    // Check the contents of lines to see if it's one you want to read next iteration
    if(line.equals("Amount"){
      isGroup=true;
    }
    else if (line.equals("Some Other Condition")) {
      isOtherCondition = true;
    }
 }