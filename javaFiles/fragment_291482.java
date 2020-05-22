for (int i = 1; i <= num; i++) {

    System.out.print("\n Enter the " + i + " number : ");
    int x = Integer.parseInt(Br.readLine());
    int j=0;
    while(j<num && nums[j]!=x) {
    j++;
    }
    if(j>=num) {
    nums[i] = x;
    }

    sum = sum + nums[i];

}