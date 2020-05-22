private void call(int profileid){

            ProfileDo profile = adapter.getProfile(profileid);

            String call = "tel:";

            for (StepDO step : profile.getSteps()) {

                String value = URLEncoder.encode(step.getValue());

                int delay = step.getDelay();

                String pausesStr = "";

                for (int i = 0; i < delay/2; i++) {

                    pausesStr += PhoneNumberUtils.PAUSE;
                }
                call += value + pausesStr;


                System.out.println(""+call);
            }
            Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse(call));

            startActivity(callIntent);
        }
    }