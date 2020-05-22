public static float shortestAngle(float from, float to) {
    float difference = to - from; //step 1: do flat difference
    difference %= 360; //step 2: do module 360 to normalize to (-360, 360) range
    if(difference < 0) {
        difference += 360; //step3: normalize to [0, 360) range
    }
    if(difference > 180) {
        difference -= 360; //step 4: normalize to (-180, 180] range
    }
    return difference;
}