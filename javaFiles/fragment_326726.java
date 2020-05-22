public Boolean containsSequences(String uname, String pwd){
  Boolean contains=false;
  for (String seq: uname.split("/[\@\-\.\_]/g")){ 
     if(pwd.contains(seq)|| pwd.contains(seq.toUpperCase())|| pwd.contains(seq.toLowerCase())){
        contains=true;
        break;
     }
  }
  return contains;
}