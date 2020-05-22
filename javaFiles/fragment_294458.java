BufferedReader br1 = new BufferedReader(
            new FileReader(fileArray[1]));

while ((line = br1.readLine()) != null) {

    StringBuffer sb1 = new StringBuffer(
            br1.readLine());
    sb1.reverse();
    String lineReversed = sb1.toString();

    byte[] bytesRead = lineReversed.getBytes();

    for (int i = 0; i < bytesRead.length; i++) {
        totalBytesRead = totalBytesRead
                + bytesRead[i];
    }
}


BufferedReader br1n = new BufferedReader(
        new FileReader(fileArray[1]));

int totalBytesReadNow = 0;
int progress = 0;

while ((line = br1n.readLine()) != null) {

    StringBuffer sb1n = new StringBuffer(
            br1n.readLine());

    sb1n.reverse();

    String lineReversed = sb1n.toString();

    byte[] bytesReadNow = lineReversed.getBytes();

    for (int i = 0; i < bytesReadNow.length; i++) {
        totalBytesReadNow = totalBytesReadNow
                + bytesReadNow[i];

        if (totalBytesReadNow >= totalBytesRead * 0.01) {
            progress = progress + 1;
            totalBytesReadNow = 0;
        }

        pb2.setValue(Math.min(progress, 100));
    }

    bwr1.write(lineReversed + "\n");
    txt2.append(lineReversed);
    Thread.sleep(0, 1);

}

bwr1.flush();
bwr1.close();
br1n.close();
br1.close();