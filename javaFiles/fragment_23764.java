int dp[51][100001];

void update(int bit[], int idx, int val){
for(int x = idx;x <= 100000;x += x & -x){
    bit[x] += val;
    if(bit[x] >= MOD) bit[x] -= MOD;
}
}

int query(int bit[], int idx){
int ret = 0;

    for(int x = idx;x > 0;x -= x & -x){
        ret += bit[x];
        if(ret >= MOD) ret -= MOD;
    }

return ret;
}

int main(){
    int N,K;

    scanf("%d %d",&N,&K);

int ans = 0;

    for(int i = 0,x;i < N;++i){
        scanf("%d",&x);

        for(int k = K;k > 1;--k)
            update(dp[k],x + 1,query(dp[k - 1],x));

        update(dp[1],x + 1,1);
    }

    printf("%d\n",query(dp[K],100000));

    return 0;
}

Explanation:

input: 1
For input 1:
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0   
0 0 1 0 1 0 0 0 1 0 0 0 0 0 0 0 // update for X=2
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 

input: 1 2
For input 2:
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 
0 0 1 1 2 0 0 0 2 0 0 0 0 0 0 0  // update for X=3, length 1; got 2 increasing subsequence  with length 1
0 0 0 1 1 0 0 0 1 0 0 0 0 0 0 0  // update for X=3, length 2;  got 1 increasing subsequence  with length 2
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 

input: 1 2 2
For input 2:
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 
0 0 1 2 3 0 0 0 3 0 0 0 0 0 0 0  // update for X=3, length 1; got 3 increasing subsequence  with length 1
0 0 0 2 2 0 0 0 2 0 0 0 0 0 0 0  // update for X=3, length 2; got 2 increasing subsequence  with length 2
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0  // But you have no increasing subsequence with length 3

input 1 2 2 10
For input 10:
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0  
0 0 1 2 3 0 0 0 3 0 0 1 1 0 0 0  // update for X=11, length 1
0 0 0 2 2 0 0 0 2 0 0 3 3 0 0 0  // update for X=11, length 2
0 0 0 0 0 0 0 0 0 0 0 2 2 0 0 0  // update for X=11, length 3;  got 2 increasing subsequence  with length 3; tihs is calculate with help of length 2