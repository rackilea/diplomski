F(idx, prev) {

     if ( idx == n+1 ) return 0; //Done with shopping on all N triplets

     ans = INFINITY

     for all item_nums from 1 to 3
            if ( item_nums != prev ) ans = min(ans, cost of item_num in shop_num idx + F(idx+1, item_nums)

    return ans
}