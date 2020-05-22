public class FruitPool extends GenericPool<Sprite> {
      // ===========================================================
      // Constants          
      // ===========================================================

      // ===========================================================          
      // Fields         
      // =========================================================== 
      private final TextureRegion mTextureRegion;
      private final Scene mAttachedScene;
      // ===========================================================          
      // Constructors          
      // =========================================================== 
      public FruitPool(final TextureRegion pFruitTextureRegion, final Scene pScene) {
           this.mTextureRegion = pFruitTextureRegion;
           this.mAttachedScene = pScene;
      }
      // ===========================================================          
      // Getter & Setter          
      // =========================================================== 

      // ===========================================================          
      // Methods for/from SuperClass/Interfaces          
      // ===========================================================  
      @Override
      protected Sprite onAllocatePoolItem() {
           Sprite newSprite = new Sprite(0, 0, this.mTextureRegion);
           this.mAttachedScene.attachChild(newSprite); //Attaching it HERE to the scene.
           return newSprite;
      }
      @Override
      protected void onHandleObtainItem(final Sprite pItem) {
           pItem.reset();
      }
      @Override
      protected void onHandleRecycleItem(final Sprite pItem) {
           pItem.setVisible(true);
           pItem.setIgnoreUpdate(true); //Just make it ignore updates while it is recycled, DON'T remove it from the scene.
      }
      // ===========================================================          
      // Methods          
      // ===========================================================  

      // ===========================================================          
      // Inner and Anonymous Classes          
      // ===========================================================  
}