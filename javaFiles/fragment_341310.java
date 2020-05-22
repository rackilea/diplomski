StringBuilder word = new StringBuilder("murder");
StringBuilder worddrow = new StringBuilder(); // starts empty

worddrow.append(word).append(word.reverse());

System.out.println(worddrow); // "murderredrum"