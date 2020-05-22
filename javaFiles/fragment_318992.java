List<SubClass> newList = new List<SubClass>();
for(Base b: list){
    if (b instanceof SubClass) {
        SubClass sub = (SubClass)b;
        . . .
        newList.add(sub);
    }
}