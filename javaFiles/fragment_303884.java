canvas.scale(scaleX, scaleY, pivotX, pivotY);  

if (scaleX >= 1){    
  objectNewX = objectOldX + (objectOldX - pivotX)*(scaleX - 1); 
}else{   
  objectNewX = objectOldX - (objectOldX - pivotX)*(1 - scaleX); 
}