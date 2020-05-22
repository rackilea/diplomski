for(Iterator<AutomatedSprite> itr = trolls.iterator(); itr.hasNext(); ){
       if(trolls.get(0).getX() < 0 - trolls.get(1).getImage().getWidth() ||      
                      trolls.get(2).getY() < 0 - trolls.get(3).getImage().getWidth() ||
                       trolls.get(4).getX() > 800 ||
                       trolls.get(5).getY() > 600){
               trolls.remove(trolls.get(5));
       }