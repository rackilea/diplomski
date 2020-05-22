StringBuilder sb = new StringBuilder();
 sb.append(list[0]).append(" ");
 for (int i = 1 ; i < size; i++) {
      sb.append(list[i]).append(" ");
      if ( (i + 1) % 8 == 0 ) { sb.append("\n"); }
 }
 System.out.print(sb.toString());