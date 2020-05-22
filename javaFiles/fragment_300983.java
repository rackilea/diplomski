public class MainActivity  implements FragmentA.FragmentEventListener {
...
...
fragmentB.setEventListener(this); // here identify the listener.
....

@Override
public void onFragmentChangeEvent(Fragment newFragment) {
    switchContent  // Switch to Fragment B here
}