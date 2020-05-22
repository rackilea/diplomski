int count = 0;
int totalVal = 0; // don't need this variable
double sum = 0.0;

while (input.hasNext()) {
    String tdate = input.next();
    String ttime = input.next();
    int tdata = input.nextInt();
    sum += tdata;
    count++;

    if (tdata <= smallest) {
        smallest = tdata;
        minDate=tdate;
        minTime=ttime; 
    }

    if (tdata >= largest) {
        largest = tdata;
        maxDate=tdate; 
        maxTime=ttime; 
    }

}

double average = sum / (double) (smallest + largest);

// the rest of your code