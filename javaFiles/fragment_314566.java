if (array [mid] > target) {
    lb = mid + 1;
}
else if (array [mid] < target) {
    ub = mid - 1;
}
else {
    retVal = mid;
}