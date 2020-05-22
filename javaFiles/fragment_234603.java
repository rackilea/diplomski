mystring=document.getElementById('other-component').value; 
if(!mystring.match(/\S/)){
alert ('Empty value is not allowed');
return false;
}else{
 alert ("correct input");
 return true;
}