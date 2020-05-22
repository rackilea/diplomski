ChainShape chain=new ChainShape();

Vector2 vector[]=new Vector2[4];
vector[0]=new Vector2((posx - size) / PPM, (posy + size) / PPM);
vector[1]=new Vector2((posx + size) / PPM, (posy + size) / PPM);
vector[2]=new Vector2((posx + size) / PPM, (posy - size) / PPM);
vector[3]=new Vector2((posx - size) / PPM, (posy - size) / PPM);

chain.createChain(vector);

System.out.println(chain.getVertexCount());  // 4 on console