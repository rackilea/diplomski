import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;


public class TabsPagerAdapter extends FragmentStatePagerAdapter {
public TabsPagerAdapter(android.support.v4.app.FragmentManager fragmentManager) {
    super(fragmentManager);
}

@Override
public Fragment getItem(int index) {
    Fragment fragment = null;
    switch (index) {

    case 0:
        // Top Rated fragment activity
        fragment =new SoloAttractionFragment();

    case 1:
        fragment = new KaranganyarAttractionFragment();
    case 2:
        // Movies fragment activity
        fragment = new SukoharjoAttractionFragment();
    }

    return fragment ;
}

@Override
public int getCount() {
    // get item count - equal to number of tabs
    return 3;
}
}