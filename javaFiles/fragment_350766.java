if (hours >= 24) {
    price = (hours / 24)*30;
    int h = hours%24;
    int h4 = Math.min(h, 3)*2;
    price += h4 +((hours)%24);

} else if (hours < 24 && hours > 3) {
    price = 9;
    price += (hours - 3) * 1;
} else {
    price = hours * 3;
}
System.out.println("Hours: " + hours + " Price: " + price);