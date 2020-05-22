public class Oldie {
    char[][] array = {
            { '0' }, { '1' }, { 'A', 'B', 'C' }, { 'D', 'E', 'F' },
            { 'G', 'H', 'I' }, { 'J', 'K', 'L' }, { 'M', 'N', 'O' },
            { 'P', 'Q', 'R', 'S' }, { 'T', 'U', 'V' }, { 'W', 'X', 'Y', 'Z' }
        };
    String num = "222";
    String savedPerm;
    int[] number = new int[num.length()];

    public static void main(String[] args) {
        Oldie oldie = new Oldie();
        oldie.givePerm(0);
    }

    Oldie(){
        for (int i = 0; i < num.length(); i++) {
            number[i] = Character.getNumericValue(num.charAt(i));
        }
    }

    private void givePerm(int position){
        String oldSavedPerm=savedPerm;
//      if(array.length!=number.length){
//          System.out.println("Different length!");
//          System.out.println(array.length+";"+number.length);
//          return;
//      }
        for (char c = array[number[position]][0]; c <= array[number[position]][array[number[position]].length - 1]; c++) {
            savedPerm=c+oldSavedPerm;
            if(position<array.length-1)
                givePerm(position+1);
            else
                System.out.println(savedPerm);
        }
    }
}