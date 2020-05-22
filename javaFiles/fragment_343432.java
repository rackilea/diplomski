for (int i = 0; i <= 7; i++) {
    for (int j = i+1; j <= 7; j++)
        for (int y = j+1; y <= 7; y++)

            if( nums[i] + nums[j] + nums[y] == 9)
                //Print the numbers on newline
                System.out.println(nums[i] + " " +nums[j] + " " + nums[y]);
}