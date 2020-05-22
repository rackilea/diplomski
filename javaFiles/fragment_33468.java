while ((line = br.readLine()) != null) {
     String [] s = line.split(cvsSplitBy);
     String o = s[1];
     String g = s[2];
     String w = s[3];
     ei.format("%d%d%d%n", o, g, w);
 }