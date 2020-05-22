double max = Double.NEGATIVE_INFINITY;
double min = Double.POSITIVE_INFINITY;
int minIndex = -1;
int maxIndex = -1;
for(int k = 3600; k < 3750; k++){
    if(max < pts[k]){
        max = pts[k];
        maxIndex = k;
    }else if(min > pts[k]){
        min = pts[k];
        minIndex = k;
    }
}