String search = "A";
for(String str: myList) {
    if(str.trim().contains(search))
       return true;
}
return false;