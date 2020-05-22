List<Integer> integers = Arrays.asList(1, 2, 3, 4);

int i = 0;
StringBuilder sb = new StringBuilder("[");
for (int value : integers) {
    sb.append((i == 0) ? "" : (i % 2 == 0 ? "," : ":")).append(value);
    i++;
}
sb.append("]");
System.out.println(sb.toString());