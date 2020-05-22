InputStream inp = new FileInputStream(encrypted);//converte il file in uno stream
OutputStream outp = socket.getOutputStream();


int count;
while ((count = inp.read(bytes)) > 0) {
    outp.write(bytes, 0, count); //scrive sulla socket del server il contenuto del file byte per byte
}
outp.close();
socket.close();