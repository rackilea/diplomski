// Increase value
value.incrementAndGet()

// Decrease value, lower bound is 0
do {
    int num = value.get();
    if (num == 0)
        break;
} while (! value.compareAndSet(num, num - 1)); // try again if concurrently updated