final List<String> names = new ArrayList<>();
final List<Integer> ages = new ArrayList<>();
mPeople.stream().forEach({ it -> 
    names.add(it.getName());
    ages.add(it.getAge());
});