class Solution {
    public int solution(int[] A) {
        ArrayList<Integer> factor1 = new ArrayList<Integer>();
        ArrayList<Integer> factor2 = new ArrayList<Integer>();       
        int factor = 1;
        int N = A.length;
        while(factor * factor <= N){
            if(N % factor == 0){
                factor1.add(factor);
                factor2.add(N / factor);
            }
            factor++;
        }

        for(int i = 1; i < factor2.size(); i++){
            int blockSize = factor2.get(i);
            int elementSize = factor1.get(i);
            int peaks = getElementSize(A, blockSize, elementSize); //call the method
            if(peaks == blockSize)
                return blockSize;
        }

        for(int i = factor1.size() - 1; i >= 0; i--){
            int blockSize = factor1.get(i);
            int elementSize = factor2.get(i);
            int peaks = getElementSize(A, blockSize, elementSize); //call the method
            if(peaks == blockSize)
                return blockSize;    
        }

        return 0;
    }

    //this method include the code which was repeated inside the loops 
    public int getElementSize(int[] A, int blockSize, int elementSize){
        int peaks = 0;
        int N = A.length;
        for(int j = 0; j < blockSize; j++){
            boolean hasPeak = false;
            for(int k = elementSize * j; k < elementSize * (j + 1); k++){
                if(k > 0 && k < N - 1){
                    if(A[k] > A[k - 1] && A[k] > A[k + 1])
                        hasPeak = true;
                }    
            } 
            if(!hasPeak)
                break; 
            else
                peaks++;
        }

        return peaks;
    }
}