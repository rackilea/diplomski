for(int x = 0; x < 64; x ++){
    textures[x] = new Sprite(
        spritesheet, 
        (x%8)*64, //where x=3, (3%8)*64 = 3*64 = 192px sourceX
        (x/8)*64, //where x=3, (int)(3/8)*64 = 0*64 = 0px sourceY
        64, //source width
        64 //source height
    );


Another test case where x=20;
(20%8)*64 = 4*64 = 256px SourceX
(20/8)*64 = 2*64 = 128px SourceY