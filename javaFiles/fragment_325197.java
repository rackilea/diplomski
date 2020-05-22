for (int i = 0; i < bin.length()/8; i++){
    System.out.println(bin.substring(indx, indx+8));
    int b = Integer.parseInt(bin.substring(indx, indx+8),2);
    out.writeByte(b);
    indx += 8;
}