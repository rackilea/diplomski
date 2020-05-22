class Kevil{
public static void main(String[] args){

int[][] num={{1,2,3,4,5,6,7,8,9,10},{11,12,13,14,15,16,17,18,19,20},{21,22,23,24,25,26,27,28,29,30}};

for(int[] i : num) {
    for(int j : i){
        System.out.print(j);
        System.out.print(" ");
    }
    System.out.print("\n");
}

}
}