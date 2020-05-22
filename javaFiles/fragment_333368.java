public class SomePropertyObserver implements Observer
{
   private ObservableValue ov = null;
   public SomePropertyObserver(ObservableValue ov)
   {
      this.ov = ov;
   }

   //This method is called whenever the observed object is changed.
   public void update(Observable obs, Object obj)
   {
      //obj is the value sent from notifyObservers called from observable
   }
}