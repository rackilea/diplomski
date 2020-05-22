public void replace(ArrayList<String> toSearchIn,String oldstr, String newStr ){
    for(int i=0;i<toSearchIn.size();i++){
        if(toSearchIn.contains(oldstr)){
            toSearchIn.set(i, toSearchIn.get(i).replace(oldstr, newStr));
        }
    }
}