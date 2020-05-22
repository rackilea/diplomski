@Override
    public void onBindViewHolder(VODViewHolder viewHolder, int i) {
        ...
        final MuscleGroup muscleGroup = muscleGroupList.get(i);
        ...
        viewHolder.wrapper.setOnClickListener(new View.OnClickListener() {
              Intent practiceIntent = new Intent(PracticeGroupActivity.this, PracticeActivity.class);
              practiceIntent.putExtra("idGroup", muscleGroup.getId());
              startActivity(practiceIntent);
        });
}