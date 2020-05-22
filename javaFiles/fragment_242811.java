import org.apache.commons.io.input.BoundedInputStream

FileInputStream file = new FileInputStream(filename);
file.skip(pos1);
BufferedReader br = new BufferedReader(
   new InputStreamReader(new BoundedInputStream(file,pos2-pos1))
);