int max = Integer.MIN_VALUE;
int min = Integer.MAX_VALUE;
int price = 100;
int dayIn = 0;
int dayOut = 0;

for (int i = 0; i < array.length; i++) {
    price += array[i];
    if (price > max) {
        max = price;
        dayOut = i;
    } 
    if (price < min) {
        min = price;
        dayIn = i;
    } 
}
if (max > min && dayIn < dayOut) { 
    System.out.printf("Buy for %d at day %d and sell on day %d for %d. Profit: %d\n", min, (dayIn + 1), (dayOut+1), max, max - min);
} else {
    System.out.println("No trade opportunity found");
}