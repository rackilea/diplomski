@Override
public String getName() {
    return "YourModule";
}

@ReactMethod
public void showYourActivity() {
   Intent intent = new Intent(mContext, YourActivity.class); // mContext got from your overriden constructor
   getCurrentActivity().startActivity(intent);
}