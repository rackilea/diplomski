private void test() {

        String[] dates = { "01:00:06", "02:30:00", "05:00:09", "01:59:06",
                "10:15:06" };
        long totalSecs=0;
        for(int i=0;i<dates.length;i++){
            totalSecs+=GetSeconds(dates[i]);
        }

        long hours = totalSecs / 3600;
        long minutes = (totalSecs % 3600) / 60;
        long seconds = totalSecs % 60;

        System.out.println("hours==> " + hours);
        System.out.println("minutes==> " + minutes);
        System.out.println("seconds==> " + seconds);

    }

    private long GetSeconds(String time){
        String[] parts = time.split(":");
        long totSec=0;
        int hour=Integer.parseInt(parts[0]);
        int min=Integer.parseInt(parts[1]);
        int sec=Integer.parseInt(parts[2]);

        totSec=(hour*3600)+(min*60)+sec;

        return totSec;
    }