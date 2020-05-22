private int distance2(int alpha, int beta) {
    int distance = beta - alpha;      // This is the distance mod 360
    if (phi <= -180) {
        distance += 360; // you were between -360 and -180 -> 0 <= distance <= 180
    else if (phi > 180) {
        distance -= 360; // you were between 180 and 360 -> 180 < distance <= 0
    }
    return distance;
}