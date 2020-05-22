alarmAdapter = new AlarmAdapter(MainActivity.this, alarmList){
    @Override
    public void onUpdateClick(int position, ArrayList<alarm> alarmList) {
                super.onUpdateClick(position, alarmList);
                Intent updateAlarmIntent = new Intent(MainActivity.this, 
                            CreateAlarmActivity.class);
                updateAlarmIntent.putExtra("alarmList", alarmList);
                updateAlarmIntent.putExtra("position", position);
                startActivity(updateAlarmIntent);
      }
};