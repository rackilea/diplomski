if (mesgcount == 1)
{
    //On First call Connect the LU62XC Message File 
    FileOutputStream MesgOut = new FileOutputStream(Mesg_File) ;
    FileChannel MesgChnl  =  MesgOut.getChannel() ;
    ByteBuffer  Mesg_Bufr =  ByteBuffer.allocate(128) ; 
}