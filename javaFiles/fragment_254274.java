int result = 0;
for (int i = 0 ; i < operands.length ; i++) {
    result += Integer.parseInt(operands[i]);
}
// or:
// int result = Arrays.stream(operands).mapToInt(Integer::parseInt).sum();
System.out.println(result);