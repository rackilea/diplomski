String[] list = {"2","A","B","1","C","3","D","E","F"};
for (int i = 0; i < list.length; ) {
    int len = Integer.parseInt(list[i]);
    System.arraycopy(list, i + 1, list, i, len);
    list[i + len] = "-empty-";
    i += len + 1;
}
for (String value : list)
    System.out.println(value);