public String shortest(){                       
    String shortest="";

    for(int i = 0; i < words.length; i++){     
        if(shortest.isEmpty())
            shortest = words[i];
        else if(shortest.length() > words[i].length())
            shortest=words[i];      
    }

    return shortest;
}