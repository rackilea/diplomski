Public class Person{
        @NotNull(groups={MethodOne.class})
        private String firstName;
        @NotNull(groups={MethodTwo.class})
        private String lastName;
        private String age;

        //getter and setter
}