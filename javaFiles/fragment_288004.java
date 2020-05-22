List<Class> classes = new LinkedList<>();

for (File file : new File(pathToClasses).listFiles()) {
    classes.add(Class.forName(file.getName().split("\\.")[0])); // if you don't have packages
}

classes.forEach(System.out::println);