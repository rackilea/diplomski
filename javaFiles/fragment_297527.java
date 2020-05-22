@Override
public Fragment getItem(int position) {
    switch (position) {
        case 0:
            return new MyFragment0();
        case 1:
            return new MyFragment1();
        case 2:
            return new MyFragment2();
    }
    return null;
}