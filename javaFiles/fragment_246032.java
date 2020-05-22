readLoop:while(true){
    try{
        sb.append(buf.readChar());
    catch(BufferUnderflowException e){
        break readLoop;
    }
}