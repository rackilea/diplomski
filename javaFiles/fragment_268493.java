int speed = 75;
int distance = 0;
//initialize variables

System.out.print("Day\tHours\tSpeed\tMiles\n");
//print header

for (int day = 1; day <= 20; day++){
//run loop untill we pass day 20

    distance += speed * 24;
    //add speed*hoursInADay (=distance traveled that day) to distance 

    System.out.print(day + "\t" + day*24 + "\t" + speed + "\t" + distance + "\n");
    //print: day    hours   speed   distance

    speed++;
    //increment speed with 1
}