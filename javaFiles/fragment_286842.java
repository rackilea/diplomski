Student st1 = new Student("Samir", "Hyderabad");
Student st2 = new Student("Akbar", "Karachi");
Student st3 = new Student("Ramu", "Abtabad");
Student st4 = new Student("Rahim", "AzadKashmir");
Student st5 = new Student("Sardar", "Udupi");
Student st6 = new Student("Fahad khan", "Jammu");

List<Student> al2 = new ArrayList<>();
al2.add(st1);
al2.add(st2);
al2.add(st3);
al2.add(st4);
al2.add(st5);
al2.add(st6);

//Alphabetical Order
Collections.sort(al2, (std1, std2) -> std1.getCity().compareTo(std2.getCity()));

//Reverse Alphabetical Order
Collections.sort(al2, (std1, std2) -> std2.getCity().compareTo(std1.getCity()));