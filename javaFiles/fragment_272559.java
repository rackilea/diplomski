ArrayList<String> input=new ArrayList<String>();
input.add("O 2");
input.add("O 2");
ArrayList<String> letters=new ArrayList<String>();
ArrayList<Integer> numbers=new ArrayList<Integer>();
for (String s:input) {
     String[] splitted=s.split(" ");
     String letter=splitted[0];
     Integer number=Integer.parseInt(splitted[1]);
     int index=-1;
     boolean isthere=false;
     for (String l:letters) {
          index++;
          if (l.equals(letter)) {
              isthere=true; //BUGFIX
              break;
          }
     }
     if (isthere==false) { //BUGFIX
         letters.add(letter);
         numbers.add(number);
     }
     else {
         numbers.set(index,numbers.get(index)+number);
     }      
}
for (int i=0; i < letters.size(); i++) {
     System.out.println(letters.get(i));
     System.out.print(numbers.get(i));
}