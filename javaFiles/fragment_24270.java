public static int[][] readMap(String[][] map){
        int counter = 0;
        int[][] wallAt = new int[map.length*map[0].length][2];   
        for(int x = 0; x < map.length ; x++){                   
            for(int y = 0; y < map[x].length; y++){    
                if(map[x][y].equals("#")){
                    wallAt[counter][0] = x;
                    wallAt[counter][1] = y; 
                }  
                else{              
                    wallAt[counter][0] = 999;
                    wallAt[counter][1] = 999;
                }

                counter++;           
            }
        }
        return wallAt;                                             
    }