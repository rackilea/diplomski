if (alarmsAmount < 7) { // SETS THE MAX AMMOUNT OF ALARMS
                        alarmFragment[alarmsAmount] = new AlarmFragment();
                        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.add(R.id.alarmListContainer, alarmFragment[alarmsAmount]); 
                        fragmentTransaction.commit();
                        alarmsAmount++;