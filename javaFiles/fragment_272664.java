String data = "mailto:email@gmail.com?subject";
int colonIndex = data.indexOf(':')+1;
int questionMarkIndex = data.indexOf('?',colonIndex);
String email = null;
if (questionMarkIndex>colonIndex){
    email = data.substring(colonIndex,questionMarkIndex);
}else{//there was no `?` after `:`
    email = data.substring(colonIndex);
}
System.out.println(email);