Sprite newCoin = coinPool.obtain();
newCoin.setPosition(x,y,z); //as desired 
newCoin.setRotation(0); //if you are rotating them
newCoin.setColor(Color.WHITE); //if you have been changing their color

activeCoins.add(newCoin); //Add your new coin to the list of active coins