LocalTime start = new LocalTime(9, 0, 0);
LocalTime stop = new LocalTime(17, 0, 0);
LocalTime time = start;     // Just use the reference

while (time.compareTo(stop) <= 0)
{
    method(time, start, stop);
    time = time.plusMinutes(1);
}