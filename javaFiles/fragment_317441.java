Instant instant = issueDate2.toInstant();
            LocalDate localDatestart = instant.atZone(defaultZoneId).toLocalDate();

            Instant instant1 = dateTo2.toInstant();
            LocalDate localDateend = instant1.atZone(defaultZoneId).toLocalDate().plusDays(1);

        Period diff = Period.between(localDatestart, localDateend);

         System.out.printf("\nDifference is %d years, %d months and %d days old\n\n", 
                        diff.getYears(), diff.getMonths(), diff.getDays());