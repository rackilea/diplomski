int sum = 0;
{ /*extra scoping block so we don't emit i*/
    int i = 0;
    while ((i += 2) <= n){
        sum += i;
    }
}