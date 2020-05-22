private <T extends Fragment> T getInitialFragment(Tab clickedTab) {

        switch (clickedTab) {
            case TAB_A:
                return (T)(new ListFragment());
            case TAB_B:
                return (T)(new SearchFragment());
        }

 }