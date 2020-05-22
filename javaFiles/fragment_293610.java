String[] m = {"01", "02", "03"};
    String[] d = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15"};
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < m.length; i++) {
        for (int j = 0; j < d.length; j++) {
            sb.append(m[i] + d[j] + " ");
        }
    }
    System.out.println(sb.toString());