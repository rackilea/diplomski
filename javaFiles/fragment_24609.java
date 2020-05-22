BufferedWriter b = new BufferedWriter(
new FileWriter ("/home/usr/Desktop/logger/logs.txt"));
b.write("hello");

//After writing close the resource
b.close();