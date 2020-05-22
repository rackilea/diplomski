loop {
  - record current time; render
  - do input/logic
  - check the current time, and calculate elapsed time
    - if less than 10 ms has elapsed, calculate the remaining time (10 millis - elapsed time); sleep for this duration
}