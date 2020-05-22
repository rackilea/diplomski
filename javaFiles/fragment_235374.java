//lock_num is the semaphore/lock object

lock_count = INCR lock_num
while(true) {
    if(lock_count != 1) {
        DECR lock_num
    } else {
        break
    }
    wait(wait_time_period)
}

//do processing in critical section

DECR lock_num