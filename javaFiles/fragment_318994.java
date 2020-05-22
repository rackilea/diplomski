List<SubClass> newList = new List<SubClass>();
for(Base b: list){
    SubClass sub = new SubClass(b);
    . . .
    newList.add(sub);
}