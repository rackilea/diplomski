while((str=in.readLine()) != null){
    if(!"[GameEvents]".equals(str)) {
        String[] splits = str.split("=");
        ret[count][0]=splits[0];
        ret[count][1]=splits[1];
        count++;
    }
}