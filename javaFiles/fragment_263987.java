class Example {

    public static void main(String[] args) {
        def lastWeek = new Date() - 7;
        def today = new Date()

        println daysBetween(lastWeek, today)
    }

    static def daysBetween(def startDate, def endDate) {
        use(groovy.time.TimeCategory) {
            def duration = endDate - startDate
            return duration.days
        }
    }
}