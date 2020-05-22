while((c=in.read())!=-1){
    out.write(c);
    if(c=='r'){
        break;
    }
}