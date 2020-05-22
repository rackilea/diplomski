@Override
public Fragment getItem(int position) {
    Fragment fragment = null;
    switch (position){
        case 0:
            fragment = new Tab1Fragment();
            break;
        case 1:
            fragment = new Tab2Fragment();
            break;
       case 2:
            fragment = new Tab3Fragment();
            break;
    }
    return fragment;
}