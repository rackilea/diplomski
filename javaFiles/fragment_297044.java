FileInputStream file = new FileInputStream("old.rtf");
FileOutputStream out = new FileOutputStream("new.rtf", true);

byte[] buffer = new byte[1024];

int count;

while ((count= file.read(buffer)) > 0) 
    out.write(buffer, 0, count);