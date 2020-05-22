public static int greatest(ArrayList<Integer> list) {
        System.out.println(list); 
        int counter = 0;

        int biggest = list.get(counter); // biggest starts at index 0 - value 3 // this counter seems to go up but the "biggest"
                                        // value remains the same when the counter below goes up.

        while (counter< list.size() ){// goes to while loop
            System.out.println("Current biggest value: " + biggest);
            System.out.println("Current iteration value: " + list.get(counter));
            if ( list.get(counter)>biggest){
                System.out.println("Current value is bigger than biggest! Changing biggest value...");
                biggest=list.get(counter);
            }

            counter++;
        }

        System.out.println(biggest);
        System.out.print(counter);  
        return biggest;   
    }            

    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<Integer>();
        lista.add(3);
        lista.add(2);
        lista.add(71);
        lista.add(2);

        System.out.println("The greatest number is: " + greatest(lista));
    }