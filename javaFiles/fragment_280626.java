long sum = 0;
for(int i : absencesArr) {       
    sum += i;
}   
// System.out.println("There were " + sum + " absences that day.");   
System.out.printf("There were %d absences that day.%n", sum);