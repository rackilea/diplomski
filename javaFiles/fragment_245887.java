//is stored only once, because if not will store where you are during rotation

yourVectorPosInicial.x = sprite.getX();
yourVectorPosInicial.v = sprite.getY();

yourVectorCenterMap.x = 400f;
yourVectorCenterMap.y = 240f;` 

youtSprite.setOrigin(yourVectorCenterMap.x-yourVectorPosInicial.x , 
                     yourVectorCenterMap.y-yourVectorPosInicial.y);

//this in your Draw or update render

sprite.rotation(10f);