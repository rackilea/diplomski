String[] read2 = new String[] {"rnbqkbnr", "pppppppp", "8", "8", "8", "8", "PPPPPPPP", "RNBQKBNR"};

for (int i = 0; i < 8; i++ ) {

    System.out.println(read2[i]);
    read2[i] = read2[i].replace("8", "11111111");
    read2[i] = read2[i].replace("7", "1111111");
    read2[i] = read2[i].replace("6", "111111");
    read2[i] = read2[i].replace("5", "11111");
    read2[i] = read2[i].replace("4", "1111");
    read2[i] = read2[i].replace("3", "111");
    read2[i] = read2[i].replace("2", "11");
    System.out.println(read2[i]);

}