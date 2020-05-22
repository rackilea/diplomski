import groovy.transform.CompileStatic

@CompileStatic
class NumTest {

    static void main(String[] args) {
        test(BigDecimal.valueOf(20))
    }

    static void test(BigDecimal number) {
        println number
    }
}