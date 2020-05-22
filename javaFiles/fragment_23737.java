try {
                SharedPreferences sharedpreferences = getSharedPreferences("my_pref", Context.MODE_PRIVATE);
                String stopDateString = "12/03/2017 11:19:00 AM";

                SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa");
                Date stopDate = dateFormat.parse(stopDateString);

                SharedPreferences.Editor editor = sharedpreferences.edit();
                Date currentTime = Calendar.getInstance().getTime();

                if (sharedpreferences.getString("Date", "").isEmpty()) {
                    editor.putString("Date", currentTime.toString());

                    button.setClickable(false);
                }


                if (currentTime.after(stopDate)) {
                    button.setClickable(true);
                }

                editor.commit();

      } catch (ParseException e) {
                e.printStackTrace();
      }