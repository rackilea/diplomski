targetRatio = targetWidth / targetHeight;
sourceRatio = sourceWidth / sourceHeight;
if(sourceRatio >= targetRatio){ // source is wider than target in proportion
    requiredWidth = targetWidth;
    requiredHeight = requiredWidth / sourceRatio;      
}else{ // source is higher than target in proportion
    requiredHeight = targetHeight;
    requiredWidth = requiredHeight * sourceRatio;      
}