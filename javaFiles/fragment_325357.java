public static void main(String[] args) {
    try {
        Analytics analytics = initializeAnalytics();
        printMobileTraffic(getMobileTraffic(analytics, profile));
    } catch (Exception e) {
        e.printStackTrace();
    }
}