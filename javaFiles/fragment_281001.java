// start all threads
for(int i=0; i<numberOfRaceCars; i++) {
    racecars[i].start();
}
// threads run... we could yield explicity to allow the other threads to execute
// before we move on, all threads have to finish
for(int i=0; i<numberOfRaceCars; i++) {
    racecars[i].join(); // TODO Exception handling
}
// now we can print
System.out.println("It's over!");