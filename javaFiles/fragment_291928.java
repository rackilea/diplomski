import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TabHostParentFragment extends Fragment {

private FragmentTabHost tabHost;

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
tabHost = new FragmentTabHost(getActivity());
tabHost.setup(getActivity(), getChildFragmentManager(), R.layout.my_parent_fragment);

Bundle arg1 = new Bundle();
arg1.putInt("Arg for Frag1", 1);
tabHost.addTab(tabHost.newTabSpec("Tab1").setIndicator("Frag Tab1"),
    NewsFragment.class, arg1);

Bundle arg2 = new Bundle();
arg2.putInt("Arg for Frag2", 2);
tabHost.addTab(tabHost.newTabSpec("Tab2").setIndicator("Frag Tab2"),
    MyNestedFragment2.class, arg2);

return tabHost;
}