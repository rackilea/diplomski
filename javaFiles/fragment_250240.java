String[] out = {
    "1st Quarter",
    "2nd Quarter",
    "3rd Quarter",
    "4th Quarter"
};

if (1 <= day && day <= 12) {
    System.out.println(out[(day - 1) / 3]);
} else {
    System.out.println("Error!");
}