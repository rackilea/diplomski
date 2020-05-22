public void onClick(View paramView) { 
          String str1 = kills.getText().toString();
          String str2 = deaths.getText().toString();

          if (str1.equals("") || str2.equals("")) {
              new AlertDialog.Builder(this)
                .setTitle("No Number")
                .setMessage("Please enter a number for both kills and deaths!")
                .setNeutralButton("Ok", null)
                .show();
                return;   
          }
          double d1 = Double.parseDouble(str2);
          double d2 = Double.parseDouble(str1);
          if ((d1 == 0.0D) || (d2 == 0.0D)) {
              new AlertDialog.Builder(this)
            .setTitle("Invalid Number")
            .setMessage("Please enter a number different than 0 for both kills and deaths!")
            .setNeutralButton("Ok", null)
            .show();
            return;
          }
          double d3 = d2 / d1;
          DecimalFormat localDecimalFormat = new DecimalFormat("#.###");
          String str3 = "Your K/D Ratio is : " + localDecimalFormat.format(d3);

          new AlertDialog.Builder(this)
            .setTitle("K/D Ratio")
            .setMessage(str3)
            .setNeutralButton("Ok", null)
            .show();
        }