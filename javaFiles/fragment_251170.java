RelativeLayout myRellayout;

@Override
public void onCreate(){
    setContenView(your.xml)
    myRelLayout = findViewByID(R.id.myrellayout);
    myRelLayout.addView(new MyCustomView(this));
    //or define your custom view and the add it by:
    //MyCustomView mcv = new MyCustomView(this);
    //myRelLayout.addView(mcv);
}