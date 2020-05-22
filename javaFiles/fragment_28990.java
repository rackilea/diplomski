public static void main(String[] args) {
    List<String> list1 = new ArrayList<>();
    list1.add("Application Scan");
    list1.add("Antivirus and HIPS");
    list1.add("Backup Administration");

    List<String> list2 = new ArrayList<>();
    list2.add("This is an example sentence that has Application Scan in it");
    list2.add("This is an example sentence that has Antivirus and HIPS in it");
    list2.add("This is an example sentence that has Backup Administration in it");

    list2.forEach(bigtext -> {
        list1.forEach(service -> {
            if (bigtext.contains(service)) {
                System.out.println(service);
            }
        });
    });
}