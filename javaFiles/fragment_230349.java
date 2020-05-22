// Remove all this:
if(x >= 0 && x <= 10 ){
    cookies1++;
}else if(x >= 11 && x<=20 ){
    cookies2++;
}else if(x >= 21 && x<=30 ){
    cookies3++;
}else if(x >= 31 ){
    cookies4++;
}
// Replace with just this line:
cookies[Math.min(x / 10, 3)]++;