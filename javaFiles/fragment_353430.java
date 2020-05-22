public static void draw(Tile tile){ //To draw the tile
            if(stack>0){
                c.setColor(Color.red);
                c.fillRect(tile.x*78+1 + tile.x, tile.y*78+1+tile.y, 78, 78); 
                   //Calculate coordinates
            }
            else{
                c.setColor(Color.blue);
                c.fillRect(tile.x*78+1 + tile.x, tile.y*78+1+tile.y, 78, 78); 
            }
        }