@Scheduled(cron = "0 15-36 8-12 * * ?")
@Scheduled(cron = "0 40-11 12-15 * * ?")
@Scheduled(cron = "0 20-35 15-16 * * ?")
 public static void testCron() {
   DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
   Date date = new Date(); 
   System.out.println("testing cron per minute " + dateFormat.format(date)); }