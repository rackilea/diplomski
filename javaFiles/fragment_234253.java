List<Double> numbers = new ArrayList<>();

Pattern pattern = Pattern.compile("-?\\d+\\.\\d+");
Matcher matcher = pattern.matcher("1_92_37.7795%2C-122.41953_87_DT");

while (matcher.find()) // jcc, sorry
    numbers.add(Double.parseDouble(matcher.group()));

System.out.println(numbers);