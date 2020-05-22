//dp[][] is memset to -1 from main
    // Assuming books are numbered 1 to n
    // change value of MAX based on your constraints
    int MAX = 1000000000;
    int rec(int position , int sub )
    {
          // These two are the base cases
          if(position > n)
          {
             if(sub == 0)return 0;
             return MAX;
          }
          if(sub == 0)
          {
              if(position > n)return 0;
              return MAX;
          }

          // If answer is already computed for this state return it
          if(dp[position][sub] != -1)return dp[position][sub];

          int ans = MAX,i,sum = 0;
          for(i = position; i <= n;i++)
          {
             sum += pages[i];
             // taking the best of all possible solutions
             ans = min(ans,max(sum,rec(i+1,sub-1)));
          }
          dp[position][sub]=ans;
          return ans; 
    }

    //from main call rec(1,m) which is your answer