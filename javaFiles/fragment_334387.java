JavaSysMon monitor=new JavaSysMon();
          //System.out.println("Operating System name is
                      "+monitor.osName());


           long usersMillis = monitor.cpuTimes().getUserMillis();
           /*System.out.println(String.format("User milli are %d days, %d
                        hr, %d min, %d sec", 
            TimeUnit.MILLISECONDS.toDays(usersMillis),
            TimeUnit.MILLISECONDS.toHours(usersMillis),
            TimeUnit.MILLISECONDS.toMinutes(usersMillis),
               TimeUnit.MILLISECONDS.toSeconds(usersMillis) 
           ));*/

          long systemMillis = monitor.cpuTimes().getSystemMillis();
          /*System.out.println(String.format("System milli are %d days, %d
                         hr, %d min, %d sec", 
            TimeUnit.MILLISECONDS.toDays(systemMillis),
            TimeUnit.MILLISECONDS.toHours(systemMillis),
            TimeUnit.MILLISECONDS.toMinutes(systemMillis),
               TimeUnit.MILLISECONDS.toSeconds(systemMillis) 
           ));*/

          long idleMilli = monitor.cpuTimes().getIdleMillis();
          /*System.out.println(String.format("Idle milli are %d days, %d
                       hr, %d min, %d sec", 
            TimeUnit.MILLISECONDS.toDays(idleMilli),
            TimeUnit.MILLISECONDS.toHours(idleMilli),
            TimeUnit.MILLISECONDS.toMinutes(idleMilli),
               TimeUnit.MILLISECONDS.toSeconds(idleMilli) 
           ));*/

          /*CpuTimes time=new CpuTimes(usersMillis, systemMillis,
                        idleMilli);
          cpuUsage=String.format("%.5f",
                       monitor.cpuTimes().getCpuUsage(time));*/
         // System.out.println("CPU Usages "+String.format("%.5f",
                        monitor.cpuTimes().getCpuUsage(time)));

          if(initialTime == null){
              initialTime = monitor.cpuTimes();
          }

          cpuUsage = new
                      Float(monitor.cpuTimes().getCpuUsage(initialTime)).toString();
          initialTime = monitor.cpuTimes();


          long cpuUpTimeL = monitor.uptimeInSeconds()*1000;

          float t = cpuUpTimeL/(float)(1000 * 60 * 60 * 24);
          int days=(int) t;
          t=t-days;
          t= (t*24);
          int hrs=(int) t;
          t=t-hrs;
          t=t*60;
          int mins=(int) t;
          t=t-mins;
          t=t*60;
          int secs=(int) t;
          cpuUpTime=GetTotalTimeTakenInJourney.getTotalTimeTaken(days, hrs,
                      mins, secs);
         // System.out.println("CPU Up time "+days+" days "+hrs+" hrs
                      "+mins+" mints "+secs+" seconds");

          //System.out.println("CPU Numbers "+monitor.numCpus());

          long totalBytes=monitor.physical().getTotalBytes();
          totalRam=totalBytes/(float)(1024*1024*1024);
          long freeBytes=monitor.physical().getFreeBytes();
          freeRam=freeBytes/(float)(1024*1024*1024);
          long ramUsages=totalBytes-freeBytes;
          usedRam=ramUsages/(float)(1024*1024*1024);