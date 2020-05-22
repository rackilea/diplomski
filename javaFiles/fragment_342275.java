final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");

LocalTime time = LocalTime.parse("20180301050630663", formatter);

if  (time.compareTo(LocalTime.of(9, 15)) >= 0
  && time.compareTo(LocalTime.of(12, 0)) <= 0)
{
    System.out.println("First period");
}
else if (time.compareTo(LocalTime.of(15, 15)) >= 0
      && time.compareTo(LocalTime.of(18, 0 )) <= 0)
{
    System.out.println("Second period");
}