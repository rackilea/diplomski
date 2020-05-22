if(input.equals(commands.commandlist()[1])){
        if(playerY > 6){
            playerY -=1;
            System.out.println("You can not move in that direction");
        } else {
            //Go north
            System.out.println(map.MapLayout()[playerX][playerY+1]);
            playerY += 1;
        }
    }