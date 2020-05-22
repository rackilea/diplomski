public void redfile() {
    try {
        ...

        long totalLength = f1.length();
        double lengthPerPercent = 100.0 / totalLength;
        long readLength = 0;
        System.out.println(totalLength);
        while ((s = br.readLine()) != null) {
            readLength += s.length();
            progressBar_1.setValue((int) Math.round(lengthPerPercent * readLength));
            ...
        }
        progressBar_1.setValue(100);
        fr.close();

    } catch (Exception e) {
         ...
    }
}