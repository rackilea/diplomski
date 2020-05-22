for (String bigText : list2) {
    for (String service : list1) {
        if (bigText.contains(service))
            System.out.println(service);
    }
}