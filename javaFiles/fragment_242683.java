while(p>=0) {
        strnew = strnew + " ";
        for(int j=spaceindex[p];;j++) {
           char c=inputString.charAt(j);
           if(c==' '){
              break;
           }
           strnew=strnew+c;
        }   
        p--;
 }