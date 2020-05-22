String periodAsHH_MM_SS = String.format("%02d:%02d:%02d", 
        TimeUnit.MILLISECONDS.toHours(diffTime),
        TimeUnit.MILLISECONDS.toMinutes(diffTime) % TimeUnit.HOURS.toMinutes(1),
        TimeUnit.MILLISECONDS.toSeconds(diffTime) % TimeUnit.MINUTES.toSeconds(1));

System.out.println("Duration in hh:mm:ss is: "+periodAsHH_MM_SS);