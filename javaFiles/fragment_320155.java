carouselPicker.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //position of the selected item
                switch (position) {
                        case 0:
                            //do smth
                            Toast.makeText(MainActivity.this, "first item selected", Toast.LENGTH_SHORT).show();
                        break;

                        case 1:
                            // do smth else
                            Toast.makeText(MainActivity.this, "second item selected", Toast.LENGTH_SHORT).show();
                        break;
                        //case 3, etc... 


                    }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });