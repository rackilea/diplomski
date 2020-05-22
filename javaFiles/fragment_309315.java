fun main(args: Array<String>) {
    val localTime = LocalTime(12, 45, 0, 0)
    val string = localTime
            .toDateTimeToday(
                    DateTimeZone.forTimeZone(TimeZone.getTimeZone("America/St_Vincent"))
            )
            .toString("HH:mm Z")

    println(string)
}