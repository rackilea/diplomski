Comparator<ClassInfo> CLASS_NAME_COMPARATOR = new Comparator<ClassInfo>() {
  public int compare(ClassInfo class1, ClassInfo class2) {
    return class1.getClassName().compareTo(class2.getClassName());
  }
};
... // implementations for other fields