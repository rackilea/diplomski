//as long as you have missiles, it'll try to fire
while(missleslist.size() > 0) {
    if (System.nanoTime() - missileStartTime  >= 1000000){
        missleslist.get(0).onDraw(canvas);
        missleslist.remove(0);
        missileStartTime = System.nanoTime();
    }
}