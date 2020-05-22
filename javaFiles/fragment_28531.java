import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

public class BuyDialogClass extends Dialog
{

//Ensure this Dialog has a Context we can use
Context mContext ;

public BuyDialogClass(Context context) {
    super(context);
    mContext=context; //Store the Context as provided from caller
}

@Override
 protected void onCreate(final Bundle savedInstanceState)
 {
  super.onCreate(savedInstanceState);
  RelativeLayout ll=(RelativeLayout) LayoutInflater.from(mContext).inflate(R.layout.dialog_buy, null);
  setContentView(ll); 
 }

}