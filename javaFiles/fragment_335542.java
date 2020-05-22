Pair<LocalDate, LocalDate> dates = getSdAndEd(today);
LocalDate sd = dates.getLeft();
LocalDate ed = dates.getRight();

private Pair<LocalDate, LocalDate> getSdAndEd(LocalDate today){
    switch (getQuarter(today.getMonthValue())){
        case 1:
            return Pair.of(
                    LocalDate.of(today.getYear(),1,1),
                    LocalDate.of(today.getYear(),3,31)
            )
        case 2:
          ...
    }
}