public OneWayFragment getOneWayFragment() {
        return (OneWayFragment) getSupportFragmentManager().findFragmentByTag(
                "android:switcher:" + R.id.viewPager + ":" + 0);
    }

public TwoFragment getTwoFragment() {
            return (TwoFragment) getSupportFragmentManager().findFragmentByTag(
                    "android:switcher:" + R.id.viewPager + ":" + 1);
        }