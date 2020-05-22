float lhsDistance = lhsLocation.distanceTo(myLocation);
float rhsDistance = rhsLocation.distanceTo(myLocation);

if (lhsDistance < rhsDistance) {
    return -1;
} else if (lhsDistance > rhsDistance) {
    return 1;
} else {
    return 0;
}