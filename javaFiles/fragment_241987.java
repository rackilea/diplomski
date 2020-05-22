for (int i = 0; i < times.length; i++) {
    if (times[i] > times[timeIndex]) {
        timeIndex = i;
        //System.out.println(names[timeIndex] + " " + times[timeIndex]);
    }

    if (times[i] > times[secondTimeIndex]) {
        if (times[i] == times[timeIndex]) {
            continue;
        }
        secondTimeIndex = i;
        //System.out.println(names[secondTimeIndex] + " " + times[secondTimeIndex]);
    }
}
System.out.println("Fastest: " + names[timeIndex] + " " + times[timeIndex]);
System.out.println("Second: " + names[secondTimeIndex] + " " + times[secondTimeIndex]);