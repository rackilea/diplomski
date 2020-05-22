new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    HscrollView1.scrollTo((int) mmBtn.getX(), 0);
                    HscrollView2.scrollTo((int) cmBtn.getX(), 0);
                }
            }, 500);