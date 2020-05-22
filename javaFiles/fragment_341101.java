if(getTitle().substring(0,5)
    == ("/[\u2190-\u21FF] | [\u2600-\u26FF] | [\u2700-\u27BF] | 
          [\u3000-\u303F] | [\u1F300-\u1F64F] | [\u1F680-\u1F6FF]/g")){
    firstCharacter = getTitle().substring(0,5);
} else{
    firstCharacter = getTitle().substring(0,1);
}