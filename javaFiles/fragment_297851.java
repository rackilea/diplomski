// Now read our file and encrypt it.
while((nread = fin.read(inbuf)) > 0) {
    fout.write(sCipher.update(inbuf, 0, nread)); // cannot be null, by construction
}
// NB doFinal() cannot return null, but can return a zero-length array, which is benign below.
fout.write(sCipher.doFinal());