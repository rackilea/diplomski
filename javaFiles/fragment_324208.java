class Mission {
    private String name;
    private String time;
    Mission(String name, String time) {
        this.name = name;
        this.time = time;
    }

    String getHour() {
        // This gives us the 2 first characters into a String - aka the "hour"
        return time.substring(0, 2);
    }
}