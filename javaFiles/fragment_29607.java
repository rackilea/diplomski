boolean found = false;
for (int i = 0; i < numrat.length - 2; i++) {
    if (numrat[i] == numrat[i+1] && numrat[i+1] == numrat[i+2]) {
        found = true;
        break;
    }
}
if (found) {
    for(int i=0;i<numrat.length;i++) {
        sum+=numrat[i];
    }
}