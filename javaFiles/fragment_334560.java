//define this object for class level access
View newView;

mainLayout = findViewById(R.id.mainLayout);

addNewMed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
addNewMed.startAnimation(AnimationUtils.loadAnimation(MedicationAdd.this, R.anim.rotate_complete));
            newView = LayoutInflater.from(MedicationAdd.this).inflate(R.layout.medication_poles, null);
mesurement = newView.findViewById(R.id.mesurement);
            mainLayout.addView(newView);
        }
    });

    if(newView != null)
        // do findviewbyid here for other views