checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked)
                Toast.makeText(MainActivity.this, "Box was checked", Toast.LENGTH_SHORT).show();

            else
                Toast.makeText(MainActivity.this, "Box was unchecked", Toast.LENGTH_SHORT).show();

        }
    });