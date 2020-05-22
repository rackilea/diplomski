document.onkeyup = function(e){
    console.log(e.target);
  if(e.target.tagName == "INPUT"){
   console.log(e.target.type);
    if(e.target.type == "text"){
        alert("Can press the key");
        return true;
    }
  }
 alert("Can't press the key"); 
 return false;
}

document.onkeydown = function(e){
 if(e.target.tagName == "INPUT"){
   console.log(e.target.type);
    if(e.target.type == "text"){
        alert("Can press the key");
        return true;
    }
  }
 alert("Can't press the key"); 
 return false;
}