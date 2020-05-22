ArrayList<Integer> ingredients = new ArrayList<>();
for (int i = 0; ingredientInput>0; i++ ){
            toppingsMenu();
            ingredientInput = ingredientScan.nextInt();
            ingredientScan.nextLine();
            ingredients.add(ingredientInput);
            System.out.println("Type your choice here:");
        }
        System.out.println(ingredientInput);