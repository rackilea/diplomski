static int compare(String input1, String input2){

        int count = 0;

        String check = input2;
        for(int i = 0; i < input1.length(); i++) 
        {
            if(check.contains(String.valueOf(input1.charAt(i)))){
                check = check.replace(String.valueOf(input1.charAt(i)), "");
                count++;
            }
        }
        return count;
}