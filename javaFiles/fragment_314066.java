st2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Intent intent = new Intent();
                intent.putExtra("background_res", R.drawable.sh4);
                setResult(RESULT_OK, intent);
                finish();
            }

    });