@Override
public void onResume(){
    //generic function that will query or get from server
    reloadData(); 
    //make sure to refresh your view. Ex: ImageView
    imageView.invalidate();
}