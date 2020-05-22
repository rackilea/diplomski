for (int i = 0; i <= 7; i++) {
    for (int j = 0; j <= 7; j++)
        for (int y = 0; y <= 7; y++)

            if( nums[i] + nums[j] + nums[y] == 9)
                //Print the numbers on newline
                System.out.println(nums[i] + " " +nums[j] + " " + nums[y]);
}