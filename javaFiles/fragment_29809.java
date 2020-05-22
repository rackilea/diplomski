byte[] numbers = { 5, 47, 31, 30, 20, 58, 11, 5, 19 }; 

OutputStream out = ...
out.write(numbers.length);
out.write(numbers);

DataInputStream in = 
byte[] bytes = new byte[in.read()];
in.readFully(bytes);