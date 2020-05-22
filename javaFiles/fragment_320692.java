@Override
 public void onActivityResult(int requestCode, int resultCode, Intent data) {


        FooChildActivity foo = (FooChildActivity)getLocalActivityManager().getCurrentActivity();
        foo.barNonStaticMethod(requestCode, resultCode, data);

 }