public static double pay (double salary, int hours) {
     int hoursWorkedRegularTime = Math.min(8, hours);
     int hoursWorkedOverTime = Math.max(0, hours - 8);
     return (hoursWorkedRegularTime * salary) +
            (hoursWorkedOverTime  * (salary * 1.5));
}