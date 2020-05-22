for(int f = 0; f < this.price; f++) {
   System.out.println("f = %d", f);
   System.out.println("getCoinSize() = %d", gamescreen.map.getCoinSize());
   System.out.println("Array Index = %d", (gamescreen.map.getCoinSize()-1-f); 
   gamescreen.map.coinsCollect.remove(gamescreen.map.getCoinSize()-1-f);
}