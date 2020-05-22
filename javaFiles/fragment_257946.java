while non-empty input lists exist {
    for each non-empty input list L {
        t = new Runnable(L.pop())
        executor.submit(t)
    }
    while (executor.hasTasks()) {
        wait
    }
}