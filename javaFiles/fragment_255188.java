for(char ch:check){
    if(!sb.toString().contains(""+ch)){
        sb.append(ch);
    }
}

System.out.println("After removing repeated character from line:\n"+sb.toString());
}