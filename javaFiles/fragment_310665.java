private Student(StudentType type, List<String> documents) {
    this.type = type;
    this.documents = documents;
}

public static Student createDomestic() {
    return new Student(StudentType.DOMESTIC), Collections.emptyList());
}

public static Student createInternational(List<Document> documents) {
    return new Student(StudentType.INTERNATIONAL, new ArrayList<>(documents);
}