public void onTimeSet(TimePicker view,int hourofDay, int minute)
        {

            time.setText(Integer.toString(hourofDay) + "." + Integer.toString(minute));

          if(time.getId==R.id.editText7){
            if(YourActivity.TimeIn !=null){
            String timeIn = YourActivity.TimeIn.getText().toString();

            float end = Float.parseFloat(time.getText().toString);
            float start = Float.parseFloat(timeIn);

            System.out.println(end-start);
           // do what you need with your calculated hours
         }
        }
        }