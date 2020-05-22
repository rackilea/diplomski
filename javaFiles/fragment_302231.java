public IotClient(String username) {
        this.username = username;
        downloader = new ScheduleDownloader("username,", "password2", "thread");
    }

new ScheduleDownloader("dunnesdrogheda", "password2", "thread").start();
        AWSIotTopic topic = new MyTopic("schedule/" + username, qos, downloader);