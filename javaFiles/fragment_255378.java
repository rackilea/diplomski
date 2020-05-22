// the Dude class does not override equals
Dude jon = new Dude("Jon", 1.2);
Dude sam = new Dude("Sam", 1.3);
jon.friend = sam;
sam.friend = jon;

Dude jonClone = new Dude("Jon", 1.2);
Dude samClone = new Dude("Sam", 1.3);
jonClone.friend = samClone;
samClone.friend = jonClone;

assertThat(asList(jon, sam)).usingRecursiveFieldByFieldElementComparator()
                            .contains(jonClone, samClone);