// PROOF OF CONCEPT ONLY! DO NOT IMITATE!
// abusing indexOf(Object) to find index of a negative integer in List

List<Integer> nums = Arrays.asList(3,4,5,-6,7);
Object equalsNegativeInteger = new Object() {
    @Override public boolean equals(Object o) {
        return (o instanceof Integer) && ((Integer) o) < 0;
    }
};
System.out.println(nums.indexOf(equalsNegativeInteger));
// prints 3