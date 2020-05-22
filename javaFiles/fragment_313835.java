int b = randomHumans.get(0).compareTo(randomHumans.get(1));

if (b>0) {
    System.out.println(randomHumans.get(0).getName()+", "+randomHumans.get(0).getAge()+" yrs old, is older than "+randomHumans.get(1).getName()+", "+randomHumans.get(1).getAge()+" yrs old.");
}
else if (b<0) {
    System.out.println(randomHumans.get(0).getName()+", "+randomHumans.get(0).getAge()+" yrs old, is younger than "+randomHumans.get(1).getName()+", "+randomHumans.get(1).getAge()+" yrs old.");
}
else {
    System.out.println(randomHumans.get(0).getName()+", "+randomHumans.get(0).getAge()+" yrs old, is just as old as "+randomHumans.get(1).getName()+", "+randomHumans.get(1).getAge()+" yrs old.");
}