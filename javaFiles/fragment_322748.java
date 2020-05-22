val statistics = NetworkStatistics(responseShouldBe, 0, 0, 1)
copy(inputStream, file.toPath(), statistics, { it: NetworkStatistics -> measureSpeed(it) }, StandardCopyOption.REPLACE_EXISTING)

private fun measureSpeed(stats: NetworkStatistics) {
    val a = stats.lastPacketBytes
    val b = stats.lastPacketTime
    val miliseconds = b.toDouble() / 1000
    val seconds = miliseconds / 1000
    println("$a per ($seconds seconds) or ($miliseconds milisecs) or ($b nanosecs) -- ${(a.toDouble()/(1024*1024))/seconds} MB/seconds")
}