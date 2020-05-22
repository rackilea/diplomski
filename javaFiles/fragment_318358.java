for(
    Iterator<String> it1 = list1.iterator(), it2 = list2.iterator();
    it1.hasNext() && it2.hasNext();
){
    assertThat(it1.next(),equalsModel(it2.next()));
}