...
Runnable runnable = new Runnable() {
    @Override
    public void run()
    {
        retrieveLineItemResultsFromPCS( mLatestBilletShopOrderNum, mLatestBilletItemNum );
    }
}
runnable.run (); // will see the old values of mLatestBilletShopOrderNum and mLatestBilletItemNum 
mLatestBilletShopOrderNum = lShopOrderNum[ 0 ];
mLatestBilletItemNum = lItemNum[ 0 ];
runnable.run (); // will see the new values of mLatestBilletShopOrderNum and mLatestBilletItemNum 
...