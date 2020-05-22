// Calculate notification timein
...
long diffTime = ...

// ensure the next alarm is in the future
while(diffTime < 0) {
    diffTime += RepeatTime;
}