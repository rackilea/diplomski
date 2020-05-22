for (Box<String, Integer> a : newlist){
    if (a.getName().equals(e.getName()) &&
        a.getMoney().equals(e.getMoney())){
        System.out.println("Found");
    }else {
        System.out.println("Not found");
    }
}