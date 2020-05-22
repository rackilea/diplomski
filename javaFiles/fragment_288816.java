public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter your birthday (YYYY-MM-DD) format: ");
        String userInput = input.nextLine();
        String[] splitValues = userInput.split("-");
        if(splitValues.length == 3) {
            int year = Integer.parseInt(splitValues[0]);
            int mon = Integer.parseInt(splitValues[1]);
            int day = Integer.parseInt(splitValues[2]);

            LocalDate birthdate = LocalDate.of(year, mon, day);
            LocalDate now =LocalDate.now();
            long age = Period.between(birthdate, now).getYears();
            System.out.println(age);
        }
    }