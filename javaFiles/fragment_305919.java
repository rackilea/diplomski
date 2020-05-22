NamedPredicate divisibleByThree = new NamedPredicate("three", i -> i % 3 == 0);
NamedPredicate divisibleByFour = new NamedPredicate("four", i -> i % 4 == 0);
NamedPredicate divisibleByFive = new NamedPredicate("five", i -> i % 5 == 0);
NamedPredicate divisibleByThreeAndFour = divisibleByThree.and(divisibleByFour);
NamedPredicate divisibleByThreeAndFive = divisibleByThree.and(divisibleByFive);
NamedPredicate divisibleByThreeAndFiveAndFour = divisibleByThreeAndFour.and(divisibleByFive);