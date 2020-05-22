// Now read our file and encrypt it.
while((nread = fin.read(inbuf)) >0) {
    byte[] trimbuf = new byte[nread];
    for(int i=0;i<nread;i++)
        trimbuf[i] = inbuf[i];

    byte[] newtmp = sCipher.update(trimbuf);
    if(newtmp != null)
        fout.write(newtmp);
}

byte[] finalbuf = sCipher.doFinal();
if(finalbuf !=null)
    fout.write(finalbuf);