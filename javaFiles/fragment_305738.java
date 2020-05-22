while (br.readLine()!=null){
    line1 = br.readLine();
    line2 = br.readLine();
    line3 = br.readLine();
    line4 = br.readLine();
    line5 = br.readLine();
    System.out.println(line1+" "+line2+" "+line3+" "+line4+" "+line5);
    Question question = new Question(line1,line2,line3,line4,line5);
    intrebari.add(question);
}