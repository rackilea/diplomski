while (true) {
    if(zis.read(buffer2) != -1) {
        os.write(buffer2);
    }
    else break;
}