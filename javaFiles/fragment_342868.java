if(0xffffff00 == (pixel & 0xffffff00))
        h.addObject(new Block(x*32, y*32,
        ID.blockStone,GameState.level1, tex));
    if(0x0000ff00 == (pixel & 0x0000ff00)){
        p.setX(x*32);
        p.setY(y*32);
        p.setHeight(64);
    }