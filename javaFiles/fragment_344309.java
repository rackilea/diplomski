public void look()
    {
        StringBuffer sb = new StringBuffer(25);

        for(int y= posY-2; y <= posY+2; y++){
            for(int x = posX-2; x <= posX+2; x++){
                try
                {
                    if(x<0 || y<0 || x > myWorld.length || y > myWorld[x].length)
                        sb.append("#");//Wall or outside map
                    else
                        if(Math.abs(posX-x)+Math.abs(posY-y) < 4)
                            sb.append(myWorld[x][y]); //Valid part of map
                        else
                            sb.append("X"); //Unreachable corner
                }
                catch(IndexOutOfBoundsException e){} //This shouldn't happen :)
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }