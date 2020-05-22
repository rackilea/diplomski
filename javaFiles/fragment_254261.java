if(inStr.charAt(i) == ('.')){
            dotCount++; //THIS LINE
            if(inStr.charAt(i+1) >= '0' && inStr.charAt(i+1) <= '9'){
                state = "accept";
                continue;
            }
            else{
                state = "reject";
                break;
            }
        }