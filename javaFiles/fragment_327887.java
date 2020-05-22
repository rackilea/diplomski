res.setContentType("audio/mpeg");

//this whole block should be in a try catch 
FileInputStream fis = new FileInputStream(new File("yourmp3file.mp3"));
int c;
while((c=fis.read())!=-1){
    res.getWriter().write(c);

}
res.getWriter().flush();