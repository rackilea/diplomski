public class PageAdapter extends FragmentStatePagerAdapter {
private ArrayList<Fragment> data;

public PageAdapter(FragmentManager fm, ArrayList<Fragment> data) {
    super(fm);
    this.data = data;
}

@Override
public Fragment getItem(int position) {
    return data.get(position);
}

@Override
public CharSequence getPageTitle(int position) {
    String title = "";
    switch (position) {
        case 0:
            title = "Game";    // this is from a template, i have to
            break;             // return title dynamically
        case 1:
            title = "Movie";
            break;
    }
    return title;
}

@Override
public int getCount() {
    return data.size();                  // the tabs number is a subject of change
}                              // i don't know it from the begining