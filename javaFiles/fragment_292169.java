@Nested
class NestedTest1 {

    @Order(3)
    @Test
    void success3() {
        System.out.println(3);
    }

    @Order(2)
    @Test
    void success2() {
        System.out.println(2);
    }

    @Order(1)
    @Test
    void success1() {
        System.out.println(1);
    }
}