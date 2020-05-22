StringBuilder buffer = new StringBuilder();
for (int i = 0; i < numbers.length; i++) {
    if (i > 0) {
        buffer.append(',');
    }
    buffer.append(numbers[i]);
}
System.out.println(buffer);