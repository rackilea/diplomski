int SIZE = 4; 
    String[] arr = str.split("\\s+");
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < arr.length; i++) {
        sb.append(arr[i]).append('\n');
        if (i % SIZE == SIZE-1) { 
            res.add(sb.toString());
            sb  = new StringBuilder();
        }
    }
    if (sb.length() != 0) res.add(sb.toString());
    System.out.println(res);
}