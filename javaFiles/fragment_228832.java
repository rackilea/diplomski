for (String key: dogs.keySet()) {
        System.out.println("Registration number : " + key);
        System.out.println("Name: " +  dogs.get(key).getName());
        System.out.println("Breed: " +  dogs.get(key).getBreed());
       }
   }