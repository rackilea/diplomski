Class<ClassList> classList = ClassList.class;
Class<?>[] classes = classList.getClasses();
for (Class<?> c : classes) {
    System.out.println(c.getName());
}

packageName.ClassList$SubClassTwo
packageName.ClassList$SubClassOne