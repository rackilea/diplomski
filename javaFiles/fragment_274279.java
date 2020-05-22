while ((line = br.readLine()) != null){
        String[] nums = line.split(" ");
        myArray[row] = new int[nums.length]; //initialize dynamically here
        for (int col = 0; col < nums.length; col++){

            int n = Integer.parseInt(nums[col]);

            myArray[row][col] = n;
        }
        row++;
}