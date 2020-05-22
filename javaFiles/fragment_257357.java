for(int i=0; i<sbuffer.length(); i++){
        for(j=i+1; j<sbuffer.length(); j++){
            if (Character.toLowerCase(sbuffer.charAt(i))==Character.toLowerCase(sbuffer.charAt(j))) {
                sbuffer.deleteCharAt(j);
                j--;
            }
        }
    }
    System.out.println(sbuffer);