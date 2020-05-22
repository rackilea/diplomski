public class MyThing {

   // save memory by only having one each
   static final Texture SHARED_TEXTURE = createTextureSomehow();
   static final Animation SHARED_ANIMATION = createAnimationSomehow();

   // instance variables, by default everybody shares the same ones...
   private Texture texture = SHARED_TEXTURE;
   private Animation animation = SHARED_ANIMATION;

   ...

   // for a special MyThing, like the nastiest Zombie, you can change the texture...
   public void setTexture(Texture newTexture) {
      this.texture = newTexture;
   }

}