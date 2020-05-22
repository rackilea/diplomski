ArrayList<Rectangle2D.Float> bulletStore=new ArrayList<>();
        Rectangle2D.Float bullet;//=new Rectangle2D.Float(bx_pos,by_pos+10,3,10);

      for(int j=0;j<by_poss.size();j++){
        by_poss.set(j, by_poss.get(j)+y_speed); //move the bullet
         bullet=new Rectangle2D.Float(bx_poss_motion.get(j),by_poss.get(j),3,10);
      //Rectangle2D.Float bulletOu=new Rectangle2D.Float(bx_pos,by_pos+10,3,10);

            g2.fill(bullet);
       bulletStore.add(bullet);
            //g2.draw(bullet);
   }



 if(b.intersects(bulletStore.get(j))){