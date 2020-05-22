//returns the k^th smallest element in the array A for 0<k<A.length  
public static int QuickSelect(int[] A, int k){

        List<Integer> AList = new ArrayList<Integer>();

        if(A.length<k||k<1){
            System.out.println("k out of range, got k: "+k +", but A.length: "+A.length);
            return -1;
        }

        for (int i = 0; i < A.length; i++){
                AList.add(A[i]);
        }