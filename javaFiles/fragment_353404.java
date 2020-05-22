String upcomingAlarmString = Settings.System.getString(getActivity().getContentResolver(),
                    Settings.System.NEXT_ALARM_FORMATTED);
            Calendar tempDate = Calendar.getInstance();
            try{
                SimpleDateFormat format = new SimpleDateFormat("EE HH:mm", Locale.getDefault());
                tempDate.setTime(format.parse(upcomingAlarmString));
            } catch (ParseException e){
                e.printStackTrace();
            }

            Calendar alarmDate = Calendar.getInstance();
            while(alarmDate.get(Calendar.DAY_OF_WEEK) != tempDate.get(Calendar.DAY_OF_WEEK)){
                if(alarmDate.get(Calendar.DAY_OF_WEEK)==7)
                    alarmDate.set(Calendar.WEEK_OF_YEAR, alarmDate.get(Calendar.WEEK_OF_YEAR) + 1);

                alarmDate.set(Calendar.DAY_OF_WEEK, alarmDate.get(Calendar.DAY_OF_WEEK)+1);
            }

            alarmDate.set(Calendar.HOUR, tempDate.get(Calendar.HOUR));
            alarmDate.set(Calendar.MINUTE, tempDate.get(Calendar.MINUTE));
            alarmDate.set(Calendar.SECOND, 0);

            System.out.println("alarmDate: " + alarmDate.getTime());
            System.out.println("calculate difference between alarmDate and now = number of days extra");