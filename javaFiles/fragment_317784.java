public static void main(String[] args) {

        System.out.println(convert("21022019"));
    }

    static LocalDate convert(String date) {
        return LocalDate.parse(date, DateTimeFormat.forPattern("ddMMyyyy"));
    }