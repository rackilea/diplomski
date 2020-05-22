public static void main(String[] args) {
        int [] num = {1,4,3,6,8,5,3,1,9,7};
        int result = 0;
        for(int i=0;i<num.length ;i++){
            for(int j =i+1;j<num.length;j++){
                result += (num[i]==num[j]?1:0);
            }
        }
        System.out.println(result);
    }