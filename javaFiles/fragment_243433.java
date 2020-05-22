@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group);

        viewPager = findViewById(R.id.create_group_view_pager);
        pagerAdapter = new CreateGroupPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        //Prevents swiping to next step.
        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                if (i == 3) {
                    CreateGroupPagerAdapter adapter = (CreateGroupPagerAdapter) viewPager.getAdapter();
                    GroupFrequencyFragment frequencyFragment = (GroupFrequencyFragment) adapter.getItem(3);
                    frequencyFragment.setActivityLabel();

                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });


    }

    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }