int numRainfallAbove = 0;
double avg = total / 12;
for (int i = 0; i < rainfall.length; i++) {
  if (rainfall[i] >= avg) {
    numRainfallAbove++;
  }
}
System.out.println("Number of months above the average rainfall:   " + numRainfallAbove);
break loop;