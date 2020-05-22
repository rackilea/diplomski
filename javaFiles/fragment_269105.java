private void setVisibility1() {
    tv1.setVisibility(View.INVISIBLE);
    tv2.setVisibility(View.VISIBLE);

    tv1.postDelayed(new Runnable() {
        @Override
        public void run() {
            setVisibility2();
        }
    }, 1000);
}

private void setVisibility2() {
    tv1.setVisibility(View.VISIBLE);
    tv2.setVisibility(View.INVISIBLE);

    tv1.postDelayed(new Runnable() {
        @Override
        public void run() {
            setVisibility1();
        }
    }, 1000);
}