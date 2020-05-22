rg = findViewById(R.id.rg);
rg1 = findViewById(R.id.rg1);

rg.setOnCheckedChangeListener((radioGroup, i) -> {
    RadioButton rb = findViewById(i);
    if (rb != null && rb.isChecked()) {
        rg1.clearCheck();
    }
});


rg1.setOnCheckedChangeListener((radioGroup, i) -> {
    RadioButton rb = findViewById(i);
    if (rb != null && rb.isChecked()) {
        rg.clearCheck();
    }
});