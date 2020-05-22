if ((east==1) && (south==1)){
    return 2;
} else if ((east==1) && (south==2)){
    return 3;
} else if ((east==0) || (south==0)) {
    return 0;
} else {
    return (numPaths(east,south-1)+numPaths(south-1,east));
}