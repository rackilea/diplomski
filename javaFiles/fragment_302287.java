private List<byte[]> split(byte[] audioData) {
    System.out.println(audioData.length);
    List<byte[]> byteList = new ArrayList<>();
    int zeroCounter = 0;
    int lastPos = 0;
    for (int i = 0; i < audioData.length; i++) {
        if (audioData[i] >= -1 && audioData[i] <= 1) {
            zeroCounter++; //too many leading 'zeros' could indicate silence or very low noise...
        } else if (zeroCounter > 0) {
            if (zeroCounter > 2000) {
                int from = lastPos;
                int to = i - (zeroCounter/2);
                byteList.add(
                    Arrays.copyOfRange(
                        audioData,
                        from,
                        to));
                System.out.println("split from: " + from + " to: " + to);
                lastPos = to;
            }
            zeroCounter = 0;
        }
    }
    return byteList;
}