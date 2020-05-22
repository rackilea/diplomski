public static void main(String...args) {
        List<Person> = new ArrayList<Person>();
        list.add(Person.getInstance());
        list.add(Person.getInstance());
        Scanner s = new Scanner(System. in );
        for (int i = 0; i < 1; i++) {
            System.out.println(list.get(i).Name = s.nextLine());
            System.out.println(list.get(i).Age = s.nextInt());
            s.nextLine(); //skips the "\n" 
        }
        s.close();
    }