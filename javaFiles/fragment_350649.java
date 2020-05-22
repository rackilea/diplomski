public class Integer2dArrays {
    public static String toString(int[][] array){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<array.length;i++) {
            for(int j=0;j<array[i].length;j++) {
                sb.append(array[i][j]).append(", ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}