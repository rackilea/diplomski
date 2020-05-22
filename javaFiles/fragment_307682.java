String[] postTypeArray = new String[]{"1 hour Before", "6 hour Before", "1 Day Before"};


        new MaterialDialog.Builder(this)
                .title("Set Reminder")
                .items(postTypeArray)
                .itemsCallback(new MaterialDialog.ListCallback() {
                    @Override
                    public void onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {

                        if (which == 0) {

                       Calendar cal = Calendar.getInstance();
                       cal.setTime(postScheduledDate);
                       cal.add(Calendar.HOUR, -1);
                       Long oneHourBack = cal.getTimeInMillis();
                       scheduleNotification(getNotification( dateStr ,""+titleStr), oneHourBack);

                            Toast.makeText(getBaseContext(), "Reminder has been setted for " + text, Toast.LENGTH_SHORT).show();
                        } else if (which == 1) {

                            Calendar cal = Calendar.getInstance();
                            cal.setTime(postScheduledDate);
                            cal.add(Calendar.HOUR, -1);
                            Long oneHourBack = cal.getTimeInMillis();
                            scheduleNotification(getNotification( dateStr ,""+titleStr), oneHourBack);

                            Toast.makeText(getBaseContext(), "Reminder has been setted for " + text, Toast.LENGTH_SHORT).show();
                        } else if ( which == 2){
                            Calendar cal = Calendar.getInstance();
                            cal.setTime(postScheduledDate);
                            cal.add(Calendar.HOUR, -1);
                            Long oneHourBack = cal.getTimeInMillis();
                            scheduleNotification(getNotification( dateStr ,""+titleStr), oneHourBack);

                            Toast.makeText(getBaseContext(), "Reminder has been setted for " + text, Toast.LENGTH_SHORT).show();
                        }

                    }
                })
                .show();