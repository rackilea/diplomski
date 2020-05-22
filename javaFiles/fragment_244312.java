if (!isAnimated){ 
          imgIconLike.setSpeed(3f); 
          isAnimated=true; 
          imgIconLike.playAnimation();
} else { 
          imgIconLike.setSpeed(-1F); 
          isAnimated=false; 
          imgIconLike.playAnimation();
}