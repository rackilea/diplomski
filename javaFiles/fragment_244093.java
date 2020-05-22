List<String> newList= new ArrayList<String>(fruitList);
     addFruits(newList);
     System.out.println("After addFruits :"+fruitList);
     System.out.println("newList:"+newList);
}

private static void addFruits(List<String> newfruitsList){
    newfruitsList.add("Papaya");
    newfruitsList.add("Guava");
}
}