while(true){
    int i = in.read(buf);
    if(i == -1)
        break;
    out.write(buf, 0, i);
}