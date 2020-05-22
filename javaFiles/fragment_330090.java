FileWriter writer = new FileWriter("/Users/xyz/desktop/lotto2010.txt");
BufferedWriter bw = new BufferedWriter(writer);

for (int i = 1; i <= 260; i++) {
    double number = Math.random() * 90;
    num = (int) number;
    list.add(num);
}

// optional step like sorting, as per your question
Collections.sort(list);

for (int i = 0; i < list.size(); i++) {
     bw.write(list.get(i).toString());
     if(i!=0 && i % n == 0) {
         bw.newLine();
     } else {
         bw.write(", ");
     }
}

bw.close();