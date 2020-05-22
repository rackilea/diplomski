for (int i = 0; i < n; i++) {
    if (a[i] == 'P') {

        for (int b = i - k; b <= i + k; b++) { //scan area to see if police can catch a thief
            if (b >= 0 && b < n && a[b] == 'T') {
                a[b] = 'C'; //caught
                break;
            }
        }

        a[i] = 'U'; //used
    }

}