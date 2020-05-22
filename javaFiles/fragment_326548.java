/* 1 */ String line;
/* 2 */ while ((line = br.readLine()) != null) {
/* 3 */     if (line.endsWith(" ")) {
/* 4 */         bw.write(line.replaceFirst(" \n", " "));
/* 5 */     }
/* 6 */ }