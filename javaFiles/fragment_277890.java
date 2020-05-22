@Override
public Fragment getItem(int index) {
    Fragment frag = null;
    switch (index) {
        case 0:
            frag = new FirstNestedFragment();
            break;
        case 1:
            frag = new SecondFragment();
            break;
        ...
    }
    return frag;
}

@Override
public Object instantiateItem(ViewGroup container, int position) {
    ObserverFragment fragment = 
            (ObserverFragment) super.instantiateItem(container, position);
    filterManager.addObserver(fragment); // add the observer
    return fragment;
}

@Override
public void destroyItem(ViewGroup container, int position, Object object) {
    filterManager.deleteObserver((ObserverFragment) object); // delete the observer
    super.destroyItem(container, position, object);
}