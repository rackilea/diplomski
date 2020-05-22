for(int y = (int)Math.max(0, Math.ceil(k.y - k.r)); y <= (int)Math.min(980, Math.floor(k.y + k.r)); y++) {
    doulbe dx = Math.sqrt(k.r * k.r - Math.abs(y-k.y) * Math.abs(y-k.y));
    for(int x = Math.max(0, (int)Math.ceil(k.x - dx)); x <= (int)Math.min(1280, Math.floor(k.x + dx)); x++) {
        cut(x,y);
    }
}