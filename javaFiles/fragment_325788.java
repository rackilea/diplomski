if((i+3)<= msgArray.size()){
    for(String tmpSeg1:msgArray.subList(i, i+3))
        {
            sb.append(tmpSeg1).append("");
        }
    }else{

     System.out.println("Exceeds size");
    }