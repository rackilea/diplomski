interface IScalable {
   void setScale(int scale);
   int getScale();
}

class DataSizeAction extends EncoderAction implements IScalable {
   ...
}

class SomeoneElse {
   private int scale = 2;

   public void setScale(IScalable scalable) {
      scalable.setScale(this.scale);
   }
}