List<Cat> cats = ...; // sorted by birthday
List<Cat> catsWithSameBirthday = new ArrayList<Cat>();
Cat key = new Cat();
key.setBirthday(...);
final int index = Collections.binarySearch(cats, key);
if (index < 0)
    return catsWithSameBirthday;
catsWithSameBirthday.add(cats.get(index));
// go backwards
for (int i = index-1; i > 0; i--) {
    if (cats.get(tmpIndex).getBirthday().equals(key.getBirthday()))
        catsWithSameBirthday.add(cats.get(tmpIndex));
    else
        break;
}
// go forwards
for (int i = index+1; i < cats.size(); i++) {
    if (cats.get(tmpIndex).getBirthday().equals(key.getBirthday()))
        catsWithSameBirthday.add(cats.get(tmpIndex));
    else
        break;
}
return catsWithSameBirthday;