public String convertToArabic(int value)
{
    String newValue = (((((((((((value+"")
            .replaceAll("1", "١")).replaceAll("2", "٢"))
            .replaceAll("3", "٣")).replaceAll("4", "٤"))
            .replaceAll("5", "٥")).replaceAll("6", "٦"))
            .replaceAll("7", "٧")).replaceAll("8", "٨"))
            .replaceAll("9", "٩")).replaceAll("0", "٠"));
    return newValue;
}