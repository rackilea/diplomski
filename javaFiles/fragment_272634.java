String[] values = title.split("€");

List<Double> doubles = new ArrayList<>();

NumberFormat format = NumberFormat.getInstance(ITALY);

for (String s : values) {
    Number number = format.parse(s.trim());
    doubles.add(number.doubleValue());
}

System.out.println(doubles);