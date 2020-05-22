import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PhotoEditorFragment extends Fragment {

@Override
public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle 
savedInstanceState) {
    View itemView=inflater.inflate(R.layout.photo_editor_fragment,container,false);
    try
    {
        return itemView;}
    catch (Exception e){
        return null;
    }

}
}