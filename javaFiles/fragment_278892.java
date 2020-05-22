public class ExternalClass{
   YouSketchName sketch;

   public ExternalClass(YourSketchName sketch){
      this.sketch = sketch;
   }

   private void dataChanged(){
      sketch.setData(42);
   }
}