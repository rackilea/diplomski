while(is.read(buffer) > 0) {
    read += buffer.length;
    os.write(buffer);
    first = Math.round(read / src.length() * 100);
    if(first != second) {
        System.out.println(first + " % copied.");
    }
    second = Math.round(read / src.length() * 100);
}