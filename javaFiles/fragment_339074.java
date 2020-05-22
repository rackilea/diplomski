String[][] animal = new String [linenumber][];

        for (int i = 0; i < linenumber; i++) {
                String line = animals.nextLine();
                String[] oneRowAnimals = line.split(",").trim();
                for(int j=0; j<oneRowAnimals.length; j++) {

                    // Here you are storing animals
                    animal[i][j] = oneRowAnimals[j];
                }
        }
        // Now you can access them by index.
        // For exmaple, this would give you "dog"
        String animalName = animal[0][1];