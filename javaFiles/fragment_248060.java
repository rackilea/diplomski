int i = 0

    @Scheduled(cron = '* * * * * * ')
    void test() {
        if (i < 5)
            Thread.sleep(10000)

        i += 1
        println '------------------------' + i // No values skipped
    }