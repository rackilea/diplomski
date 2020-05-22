static public void main(String[] args) {
    ExampleTest x=new ExampleTest(); // in your case, it's Basics

    x.graph=new HashMap<>();
    x.graph.put(1, new HashSet<>(Arrays.asList(2)));
    x.graph.put(2, new HashSet<>(Arrays.asList(1,3)));
    x.graph.put(3, new HashSet<>(Arrays.asList(2,4)));
    x.graph.put(4, new HashSet<>(Arrays.asList(3,5)));
    x.graph.put(5, new HashSet<>(Arrays.asList(4,6)));
    x.graph.put(6, new HashSet<>(Arrays.asList(5)));
    System.out.println(x.checkLevelBFS(1, 2)); // true
    System.out.println(x.checkLevelBFS(1, 3)); // true
    System.out.println(x.checkLevelBFS(1, 4)); // true
    System.out.println(x.checkLevelBFS(1, 5)); // true
    System.out.println(x.checkLevelBFS(1, 6)); // false
  }