LocalDate date = LocalDate.now();
int yearNow = date.getYear();
int minYear = yearNow - 5;

while(yearNow >= minYear) {
    System.out.println(yearNow--);
}