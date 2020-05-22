int numRead;

while( (numRead = is.read(buffer)) >= 0) {
    read += numRead;
    os.write(buffer,0,numRead);
    first = Math.round(read / src.length() * 100);
    if(first != second) {
        System.out.println(first + " % copied.");
    }
    second = Math.round(read / src.length() * 100);
}