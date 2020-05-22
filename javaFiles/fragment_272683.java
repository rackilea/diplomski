double freq[]=new double[nb_points];
        double pxx[]=new double[nb_points];
        int nb_point=100;

        for (int i=0; i<bytes/2;i=i+15)
        {
            String strReceived_freq = new String(buffer,i, i+15);
            try {
                freq[i]=Double.parseDouble(strReceived_freq);
            }catch (NumberFormatException e){
                freq[i]=0;
            }

            freq[i]=Double.parseDouble(strReceived_freq);
            freq_value.setText(String.valueOf(freq[i]));
        }