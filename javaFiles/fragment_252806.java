public void addObj(Tratum trat) {
        Tratum[] arrayObj2 = new Tratum[3];
        Date date = trat.getNextTime();
        for (int n = 0; n < 3; n++) {
            arrayObj2[n] = trat; // I think this line is the culprit
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.SECOND, n + 1000 * n);
            date = cal.getTime();
            Log.d("inTemp","" + date.toString());

            arrayObj2[n].setNextTime(date);
            if(n ==1){
                if(arrayObj2[n].equals(arrayObj2[n-1])){
                    Log.d("TEMP","$$Equal");
                }
            }
            arrayListTrat.add(arrayObj2[n]);
        }