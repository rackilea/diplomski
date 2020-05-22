private static void processScanLine(byte filterValue, byte[] scanLine, byte[] previousScanLine) {
    switch(filterValue){
        case 0:break;
        case 1:
            for (int i =4;i<scanLine.length;i++){
                scanLine[i] = (byte)(scanLine[i]+scanLine[i-4]);
            }
        break;
        case 2:
            for (int i =0;i<scanLine.length;i++){
                scanLine[i] = (byte)(scanLine[i]+previousScanLine[i]);
            }
        break;
    }
}