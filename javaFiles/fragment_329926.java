if(pc.bounds.overlaps(gary.Rbounds))
  {
    if(pc.onquest = false){ // HERE YOU ARE DOING TWO THINGS: assing false to 
                            // onquest and return false. The following code is never execute 
        if(pc.finishquest = false){ // SAME HERE
        Assets.font.draw(batch, gary.Gdio, pc.bounds.x - 250, pc.bounds.y - 190);
        pc.onquest = true;
        }
    }
    if(pc.onquest = true){// SAME HERE
        if(pc.finishquest = false){// SAME HERE
        Assets.font.draw(batch, gary.GDdio, pc.bounds.x - 250, pc.bounds.y - 190);
        }
        }
    if(pc.haspoints = true){// SAME HERE
        pc.finishquest = true;
    }
    if(pc.finishquest = true);// SAME HERE
    Assets.font.draw(batch, gary.GCdio, pc.bounds.x - 250, pc.bounds.y - 190);
    pc.onquest = false;
    pc.award = true;
}`