import java.util.*;
    import java.io.*;

    public class ImageMatrixDB implements Iterable<ImageMatrix> {
        private List<ImageMatrix> list = new ArrayList<ImageMatrix>();

        public ImageMatrixDB load(String f) throws IOException {
            try (
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr)) {
                String line = null;

                while((line = br.readLine()) != null) {
                    int lastComma = line.lastIndexOf(',');
                    int classCode = Integer.parseInt(line.substring(1 + lastComma));
                    int[] data = Arrays.stream(line.substring(0, lastComma).split(","))
                                       .mapToInt(Integer::parseInt)
                                       .toArray();
                    ImageMatrix matrix = new ImageMatrix(data, classCode);
                    list.add(matrix);
                }
            }
            return this;
        }

        public void printResults(){
            for(ImageMatrix matrix: list){
                System.out.println(matrix);
            }
        }


        public Iterator<ImageMatrix> iterator() {
            return this.list.iterator();
        }
        public static void main(String[] args){
            ImageMatrixDB i = new ImageMatrixDB();
            try{
                i.load("cw2DataSet1.csv"); 
                i.printResults();
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }

    }