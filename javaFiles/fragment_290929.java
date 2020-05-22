final Runnable Update = new Runnable() {
                public void run() {
                    if (currentPage < NUM_PAGES) {
                         mPager.setCurrentItem(currentPage++, true);
                    }
                }
            };