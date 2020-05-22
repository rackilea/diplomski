StringBuilder array = new StringBuilder();

array.append("int[] arr = new int[] {").append("\n");
for (int i = 0; i < 10; ++i) {
    array.append(i + ",").append("\n");
}
array.append("}").append("\n");