public ClassB(List<ClassA> source) {
        ClassA item = source.get(0);
        if(“1”.equals(item.getKeyword())
             this.newtitle = item.getTitle();
        else if(“2”.equals(item.getKeyword())
             this.newtitle = “specialValue”; // or make a call to a method to compute the value
        this.joinedDescriptions = String.join(“, “, source.stream().map(ClassA::getDescription).collect(toList()));
}