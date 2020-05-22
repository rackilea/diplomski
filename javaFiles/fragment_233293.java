double lengthPerPercent = 100.0;
long readLength = 0;
FileReader fr=new FileReader("mario.txt");
BufferedReader br=new BufferedReader(fr);
while((r = br.readLine())!= null){
    readLength += r.length();
    jProgressBar1.setValue((int)(lengthPerPercent * readLength));