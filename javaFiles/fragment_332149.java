I would suggest maintain a list like
private List<Fragment> frag = new ArrayList<Fragment>();
then
public class SearchPagerAdapter extends FragmentStatePagerAdapter {
CharSequence Titles[];
int NumbOfTabs;
public SearchPagerAdapter(FragmentManager fm,CharSequence mTitles[], int mNumbOfTabsumb) {
    super(fm);
    this.Titles = mTitles;
    this.NumbOfTabs = mNumbOfTabsumb;
}
@Override
public Fragment getItem(int position)
 {
   Fragment fragment = frag.get(position);
    if(fragment == null )
    {
        if (position == 0)
        {
          fragment = new FragmentAyahSearch();    
        }

        else
        {
          fragment = new FragmentSurahList();

        }
     }
    return fragment;
}

@Override
public CharSequence getPageTitle(int position) {
    return Titles[position];
}
@Override
public int getCount() {
    return frag.size();
}

now if you want the reference of any fragment
just call , frag.get(<position>) will return you desire frgament