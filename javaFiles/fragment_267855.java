case R.id.calculate2:

        if (nicknameStr.length() > 0 && origBalStr.length() > 0 && myAPRStr.length() > 0 && origTermStr.length() > 0 && myPmtStr.length() > 0)
        {               

            double originalBalance = Double.parseDouble(origBalStr);
            double interestRate = Double.parseDouble(myAPRStr);
            double originalTerm = Double.parseDouble(origTermStr); 
            double remainingBalance = Double.parseDouble(strOutBal);

            double r = interestRate/1200;
            double r1 = Math.pow(r+1,originalTerm);

            double minPmt = (double) ((r+(r/(r1-1))) * originalBalance);
            DecimalFormat df = new DecimalFormat("#.##");      
            minPmt = Double.valueOf(df.format(minPmt));

            dispMinPmt.setText("" + String.valueOf(minPmt));


            double additionalPayment = Double.parseDouble(myPmtStr);
            double newPmt = minPmt + additionalPayment;

            dispNewPmt.setText("" + newPmt);

            double periodRate = r;

            double remTop = ((-1*Math.log(1-(periodRate) * (remainingBalance / newPmt))));
            double remBottom = (Math.log(1 + periodRate));
            double nRemaining = remTop / remBottom;

            double initialInt = (minPmt * nRemaining) - remainingBalance;
            double newInt = (newPmt * nRemaining) - remainingBalance;
            double amountSaved = initialInt - newInt;

        }
        else
        {
            Toast.makeText(getApplicationContext(), "Please complete all above fields", Toast.LENGTH_SHORT).show();
        }

        break;