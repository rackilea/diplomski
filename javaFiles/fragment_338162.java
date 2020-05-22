public add2cart extends Activity{

public static String sme;

}

public CartAdapter extends BaseAdapter{

String some = add2cart.sme ;

}

OR

public add2cart extends Activity{
String sme; 

//pass it in constructor

CartAdapter adapter = new CartAdapter(this,pname,price, sme);
adlstvw.setAdapter(adapter);

}

//fetch it in CartAdapter constructor