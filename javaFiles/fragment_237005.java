static int fun(int[] a, int[] stack, int frame) {
    if(a.length == frame) {
        print(stack);
        return 1;
    }
    int res = 0;
    for(int i = 0;i<a.length;i++) {
        //save stack
        int[] temp = new int[stack.length];
        save(stack, temp);
        if(isValid(stack, a[i]) == true) {
            stack[frame] = a[i];
            res += fun(a, stack, frame+1);
            //restore stack
            restore(temp, stack);
        }
    }
    return res;
}