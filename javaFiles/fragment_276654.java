while(numLine == 0){   // As numLine doesn't get chance to get updated you end up with infinite loop
        if(content.length() > 70){  // Initially this condition is false
            content = content + "\n";
            numLine = numLine + 1;   // So initially this statement is not reached
        }
    }