for (Sprite coin : activeCoins){
    boolean grabbed = isCoinGrabbed(coin); //however you want to do this
    if (grabbed){
        coinGrabbed(); //whatever you want to happen when a coin is grabbed

        activeCoins.remove(coin);
        coinPool.free(coin); //return it to the pool
    }
}