public class MyClass extends Activity implements OnSwipeListener
{
 protected void onCreate(Bundle stuff)
 {
  //
  this.setOnTouchListener(new SwipeRecogniser(this));
 }

 public void onUpwardsSwipe(){/*methods*/}
 public void onDownwardsSwipe(){/*methods*/}
 public void onLeftwardsSwipe(){/*methods*/}
 public void onRightwardsSwipe(){/*methods*/}
}