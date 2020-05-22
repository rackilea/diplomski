int count = 0;
for (boolean[][] bArrArr : StarTrack) {
    for (boolean[] bArr : bArrArr) {
        for (boolean b : bArr) {
            if (b) {
                count++;
            }
        }
    }
}
System.out.println(count);