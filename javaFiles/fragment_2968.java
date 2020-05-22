if (str > 0) {
    System.out.print("This is the " + calc1);
    int unity = calc1%10;
    String century;
    if (unity == 1) century = "st";
    else if (unity == 2) century = "nd";
    else if (unity == 3) century = "rd";
    else century = "th";
    System.out.print(century + " century. I'm sure of it!");
else
    System.out.print("Please don't input negative numbers :c");
}