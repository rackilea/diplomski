bool foundSum(vector<int> set, int n, int sum) {
    if(sum == 0) return true;
    if(n == 0 and sum != 0) return false;

    int last = set[n-1];

    if(last > sum) return foundSum(set, n-1, sum);
    return foundSum(set,n-1,sum) or foundSum(set,n-1,sum-last);
}