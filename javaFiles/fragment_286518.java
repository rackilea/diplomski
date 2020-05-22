for (i in 1..4) {
    Thread { 
        if (i % 2 == 0)
            return@Thread
        println("Thread $i")
    }.run()
}