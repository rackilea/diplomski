FileInputStream file = new FileInputStream("old1.rtf");
FileOutputStream out = new FileOutputStream("new.rtf");

byte[] buffer = new byte[1024];

int count;

while ((count= file.read(buffer)) > 0) 
    out.write(buffer, 0, count);

file.close();

file = new FileOutputStream("old2.rtf");
while ((count= file.read(buffer)) > 0) 
    out.write(buffer, 0, count);