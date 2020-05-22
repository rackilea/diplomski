...
if (comp==0) {
    return mid;
} else if (comp<0) {
    return binaryrSearch(cards , target , mid+1 , high);
} else {
    return binaryrSearch(cards , target , low , mid-1);
}
...