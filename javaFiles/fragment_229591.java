public static void main(String[] args) throws Exception
      { 
         .......
         ArrayList<String> names=new ArrayList<String>();
         ArrayList<Integer> numbers=new ArrayList<Integer>();
         ArrayList<Double> num2=new ArrayList<Double>();
         ArrayList<Character> letters=new ArrayList<Character>();

         ReadFromFile(input,names,numbers,letters,num2);

         System.out.println(names);
         System.out.println(numbers);
         System.out.println(letters);
         System.out.println(num2);
        }