double average() {
    double sum = 0.0;
    for (int i = 0; i < nums.length; i++)
        if( nums[i] instanceof Double) {                    
            sum += nums[i].doubleValue();
        } else if(nums[i] instanceof Integer) {
            sum += nums[i].intValue();
        }
    return sum / nums.length;
}