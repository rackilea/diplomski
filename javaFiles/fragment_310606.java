TraceCPUTime::~TraceCPUTime() {
  if (_active) {
    bool valid = false;
    if (!_error) {
      double real_secs;                 // walk clock time
      double system_secs;               // system time
      double user_secs;                 // user time for all threads

      double real_time, user_time, system_time;
      valid = os::getTimesSecs(&real_time, &user_time, &system_time);
      if (valid) {

        user_secs = user_time - _starting_user_time;
        system_secs = system_time - _starting_system_time;
        real_secs = real_time - _starting_real_time;

        _logfile->print(" [Times: user=%3.2f sys=%3.2f, real=%3.2f secs] ",
          user_secs, system_secs, real_secs);

      } else {
        _logfile->print("[Invalid result in TraceCPUTime]");
      }
    } else {
      _logfile->print("[Error in TraceCPUTime]");
    }
     if (_print_cr) {
      _logfile->print_cr("");
    }
  }
}