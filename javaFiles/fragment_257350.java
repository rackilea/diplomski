if (aPixels_org != null &&
    aPixels_dup != null &&
    aPixels_org.length == aPixels_dup.length &&
    aPixels_org.length == iWidth*iHeight )
{
    l.info("Array sizes match");
    System.arraycopy(aPixels_org,0,aPixels_dup,0,iWidth*iHeight);
    l.info("Array Copied");
}
else{l.warn("Something is NULL or dimensions are off");}
l.info("");