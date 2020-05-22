import java.util.Random;
Random randgen = new Random();

byte[] fuzzbytes = new byte[numbytes];
randgen.nextBytes(fuzzbytes);
outstream.write(fuzzbytes, 0, numbytes);