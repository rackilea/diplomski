@Override
public void onStart() {
super.onStart();
EventBus.getDefault().register(this);//Register 
 }

@Override
public void onStop() {
super.onStop();
EventBus.getDefault().unregister(this);//unregister
}