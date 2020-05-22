public class Permutation {
    public static void main(String[] args) {
        java.util.List<StringBuilder> result=new java.util.ArrayList<StringBuilder>();
        permute(java.util.Arrays.asList(1,2,3,4), 0,result);
        for(StringBuilder sb:result)
            System.out.println(sb.toString());
    }

    static void permute(java.util.List<Integer> arr, int k, java.util.List<StringBuilder> result){
        for(int i = k; i < arr.size(); i++){
            java.util.Collections.swap(arr, i, k);
            permute(arr, k+1,result);
            java.util.Collections.swap(arr, k, i);
        }
        if (k == arr.size() -1){
            result.add(new StringBuilder(java.util.Arrays.toString(arr.toArray())));      
        }
    }
}