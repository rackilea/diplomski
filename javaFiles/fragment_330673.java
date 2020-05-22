// Assuming you have a scanner object named s and pointed to your file:

// PointNumber: 33530
int pointNumber = 0;
while(!s.next().equals("PointNumber:")) {
    pointNumber = s.nextInt();
}

// Lat: 8.99167773897820e-001
double lat = 0.0;
while(!s.next().equals("Lat:")) {
    lat = s.nextDouble();
}

// Lon: 6.20173660875318e+000
double lon = 0.0;
while(!s.next().equals("Lon:")) {
    lon = s.nextDouble();
}

// Alt: 0.00000000000000e+000
double alt = 0.0;
while(!s.next().equals("Alt:")) {
    alt = s.nextDouble();
}

// NumberOfAccesses: 4
int numberOfAccesses = 0;
while(!s.next().equals("NumberOfAccesses:")) {
    numberOfAccesses = s.nextInt();
}

// 0 4.80784667215499e+003 4.80872732950073e+003
// 0 1.05264215520092e+004 1.05273043378212e+004
// 1 1.65167780853593e+004 1.65185840063538e+004
// 1 6.52228387069902e+004 6.52246514228552e+004

// Assuming you have defined an Access class
LinkedList<Access> accesses = new LinkedList<Access>();
for(int i = 0; i < numberOfAccesses; i++) {
    // Assuming this is the constructor for the Access class
    accesses.add(new Access(s.nextInt(), s.nextDouble(), s.nextDouble()));
}