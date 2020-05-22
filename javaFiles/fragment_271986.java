bx.setOnLongClickListener(new OnLongClickListener() {

        @Override
        public boolean onLongClick(View v) {
            TextView tv = (TextView)v;
            String selectedValue = tv.getText().toString();
            return false;
        }
});