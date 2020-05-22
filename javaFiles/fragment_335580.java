public static void main(String[] args) {
  String[] input = {"7394;dasd;dasda;dasda;5;3", "2222;dasdasd;das;true;7;4;dsda;60",
                    "6660;dsada;dasasd;true;6;3", "2345;dasdsagfd;das;true;7;4;gfgfdgd;60"};
  Vector<String> vec = new Vector<>();
  vec.addAll(Arrays.asList(input));
  System.out.println("Input : " + vec);

  Collections.sort(vec, new Comparator<String>() {

     @Override
     public int compare(String o1, String o2) {
        int i1 = Integer.valueOf(o1.split(";")[0]);
        int i2 = Integer.valueOf(o2.split(";")[0]);

        return i1 - i2;
     }
  } );

  System.out.println("Result: " + vec);      
}