struct sigevent sev;
timer_t timerid;
memset(&sev, 0, sizeof(sev));
sev.sigev_notify = SIGEV_THREAD;
sev.sigev_notify_function = handler;
sev.sigev_value.sival_ptr = &timerid;
timer_create(CLOCK_MONOTONIC, &sev, &timerid);