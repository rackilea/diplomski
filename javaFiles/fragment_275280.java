for(int character=0; character<roomNo.length(); character++){
    if(!Character.isDigit(roomNo.charAt(character))) {
         return false;
    }
}
return true;