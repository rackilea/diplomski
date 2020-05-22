NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
try {
    Number number = format.parse(formDto.getWeight().replace('.', ','));
    kitten.setWeight(number.doubleValue());
} catch (ParseException e) {
    e.printStackTrace();
}