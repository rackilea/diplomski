List<MyClass> list = new ArrayList<>();

list.add(new MyClass(null, LocalDate.now()));
list.add(new MyClass(4L, LocalDate.now()));
list.add(new MyClass(2L, LocalDate.now()));
list.add(new MyClass(4L, LocalDate.now().plusDays(1)));
list.add(new MyClass(null, LocalDate.now().plusDays(1)));

Comparator<MyClass> comparator = Comparator.comparing(MyClass::getId, Comparator.nullsLast(Comparator.reverseOrder()))
                .thenComparing(MyClass::getCreateDate);

list.stream().sorted(comparator).forEach(myClass -> System.out.println(myClass.id + " " + myClass.createDate));