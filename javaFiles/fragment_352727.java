if (timeOfDay >= 5 && timeOfDay <= 8) {
            imageView.setImageResource(R.drawable.sunset);

        } else if (timeOfDay >= 9 && timeOfDay <= 16) {
            imageView.setImageResource(R.drawable.morning);

        }
        else if (timeOfDay >= 17 && timeOfDay <= 19) {
            imageView.setImageResource(R.drawable.sunset);
        }
        else{
             //exectue this for 0-4 and 20-24
            imageView.setImageResource(R.drawable.night);
        }