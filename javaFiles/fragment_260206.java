boolean searchNumArray(int[] arr, int num) {
    int left = 0;
    int right = arr.length - 1;
    while (left < right) {
        int sum = arr[left] + arr[right];
        if (sum == num) {
          return true;
        } else if (sum > num) {
          right--;
        } else {
          left++;
        }
    }
    return false;
}