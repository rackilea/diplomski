public class TestTest {

    class TestOptional {

        public TestOptional(){
            System.out.println("TestOptional constructor called.. " + this);
        }

        List<String> getDocIds(){
            System.out.println("TestOptional#getDocIds called.. " + this);
            return new ArrayList<>(Collections.singletonList("test"));
        }

        List<String> getEmptyDocIds(){
            System.out.println("TestOptional#getEmptyDocIds called.. " + this);
            return new ArrayList<>();
        }
    }

    @Test(expected = Exception.class)
    public void test() throws Exception {

        Optional<TestOptional> optionalVal = Optional.of(new TestOptional());
        Optional<TestOptional> optionalValEmpty = Optional.empty();

        boolean deleted = optionalVal
                .map(TestOptional::getDocIds)
                .orElse(new TestOptional().getEmptyDocIds())
                .remove("test");

        System.out.println("One: " + deleted);

        System.out.println("\n ### \n");

        boolean deletedTwo = optionalVal
                .map(TestOptional::getDocIds)
                .orElseGet(() -> new TestOptional().getEmptyDocIds())
                .remove("test");

        System.out.println("Two: " + deletedTwo);

        System.out.println("\n ### \n");

        boolean deletedThree = optionalValEmpty
                .map(TestOptional::getDocIds)
                .orElse(new TestOptional().getEmptyDocIds())
                .remove("test");

        System.out.println("Three: " + deletedThree);

        System.out.println("\n ### \n");

        boolean deletedFour = optionalValEmpty
                .map(TestOptional::getDocIds)
                .orElseGet(() -> new TestOptional().getEmptyDocIds())
                .remove("test");

        System.out.println("Four: " + deletedFour);

        assertThat(deleted).isTrue();
        assertThat(deletedTwo).isTrue();
        assertThat(deletedThree).isFalse();
        assertThat(deletedFour).isFalse();
    }
}