BufferedWriter br = new BufferedWriter(new FileWriter("myfile.csv"));
StringBuilder sb = new StringBuilder();

// Append strings from array
for (String element : array) {
 sb.append(element);
 sb.append(",");
}

br.write(sb.toString());
br.close();