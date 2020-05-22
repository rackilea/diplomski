float max = f[0];
for (float fl : f){
    if (fl>max){
        max = fl;
    }
}
float min = f[0];
for (float fl : f){
    if (fl<min){
        min = fl;
    }
}
float maxdiff = max-pp.basePoint;
float mindiff = pp.basePoint-min;
float diff;
if (maxdiff>mindiff){
    diff = maxdiff;
} else {
    diff = mindiff;
}
pp.diff = diff;