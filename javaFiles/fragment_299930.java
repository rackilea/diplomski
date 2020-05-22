LocalDate startDate = LocalDate.of(2015, 11, 26);
int businessDays = 2;
LocalDate endDate = startDate.plusDays(getAllDays(startDate.getDayOfWeek().getValue(), businessDays));

System.out.println(startDate + (businessDays > 0 ? " plus " : " minus ") + Math.abs(businessDays)
        + " business days: " + endDate);

businessDays = -6;
endDate = startDate.minusDays(getAllDays(startDate.getDayOfWeek().getValue(), businessDays));

System.out.println(startDate + (businessDays > 0 ? " plus " : " minus ") + Math.abs(businessDays)
        + " business days: " + endDate);