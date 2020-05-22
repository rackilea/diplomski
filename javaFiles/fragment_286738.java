File fo = new File(arquivo+".csv");
FileOutputStream fos = new FileOutputStream(<some path>+"\\"+fo);
PrintWriter write = new PrintWriter(fos);   

write.println(text);
write.close();