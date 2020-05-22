int half = (int) Math.ceil(number/2.0);


while (numbers <= number && sharepoints > number){ 

    System.out.println(numbers + "  " + sharepoints);

    if(numbers < half) {
    sharepoints += 50;    
    }
    else {
    sharepoints -= 25;    
    }
    numbers++;
}