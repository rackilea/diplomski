// Get a reference to the TitlePageIndicator
awesomeIndicator = (TitlePageIndicator) findViewById(R.id.indicator);

// Attach adapter to ViewPager
awesomePager.setAdapter(awesomeAdapter;

// Attach ViewPager to the indicator
awesomeIndicator.setViewPager(awesomePager);