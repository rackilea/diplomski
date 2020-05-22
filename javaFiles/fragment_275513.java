public static ConcurrentHashMap<String, Timer> PostCache = new ConcurrentHashMap<>();
  public String Schedulepost(Igpost igpost) throws ParseException {
        String res = "";
        TimerTask task = new TimerTask() {
            public void run() {
                System.out.println("Sample Timer basedTask performed on: " + new Date() + "\nThread's name: " + Thread.currentThread().getName());
                System.out.println(igpost.getPostdate()+" "+igpost.getPosttime());
            }
        };
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = dateFormatter.parse(igpost.getPostdate()+" "+igpost.getPosttime());
        Timer timer = new Timer(igpost.getImageurl());
        CacheHelper.PostCache.put(igpost.getImageurl(),timer);
        timer.schedule(task, date);
        return  res;
    }