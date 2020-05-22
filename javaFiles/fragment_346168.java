Car car1 = new Car("Jones, Sam", "2017 Honda Accord", 222000, true);
Car car2 = new Car("Jones, Sam", "2017 Honda Accord", 222000, true);
Car car3 = new Car("Jones, Samual", "2017 Honda Accord", 222000, true);

assertThat(car1, is(car2));
assertThat(car1, not(car3));