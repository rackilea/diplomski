import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Activity;
import android.webkit.WebView;

public class TopRatedFragment extends Fragment {

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {

    View rootView = inflater.inflate(R.layout.fragment_top_rated, container, false);

    WebView engine = (WebView) rootView.findViewById(R.id.web_engine); // `web_engine` must be in `fragment_top_rated`
    engine.loadUrl("http://www.google.com/");
    return rootView;
  }
}