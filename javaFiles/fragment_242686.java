int retcnt = 0;
for (//...) {
    //...
}
// The variable retcnt is now accessible for the entire method scope, 
// instead of just the loop block
return retcnt;