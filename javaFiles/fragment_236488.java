import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;



  SpannableString str = new SpannableString("your string");
  Linkify.addLinks(str, Linkify.WEB_URLS);

  textview.setText(str);
  textview.setMovementMethod(LinkMovementMethod.getInstance());