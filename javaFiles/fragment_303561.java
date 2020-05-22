double bytesRead += (sCurrentLine.getBytes().length);

int newPercentRead = (int)((bytesRead/fileSize) * 100);

while (percentRead <= newPercentRead){

    System.out.print("#");

    percentRead++;

}