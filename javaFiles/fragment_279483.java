public void tick(){
    switch(pos){
        case 3: x+=10; break;
        case 2: x-=10; break;
        case 1: y-=10; break;
        case 0: y+=10; break;
    }
}