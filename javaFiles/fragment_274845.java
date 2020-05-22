public class Main {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 5, 4, 6, 7, 8, 9, 10);

        System.out.println(processStream(numbers)); 
        System.out.println(getNumber(numbers));
        System.out.println(getNumberEfficient(numbers));
    }

    static Stream<Integer> processStream(List<Integer> numbers){
        return numbers.stream()
                .filter(e -> {
                    System.out.println("GT3: " + e);
                    return e > 3;
                })
                .filter(e -> {
                    System.out.println("is Even: " + e);
                    return e % 2 == 0;
                })
                .map(e -> {
                    System.out.println("times 2: " + e);
                    return e * 2;
                } );
    }

    static int getNumberEfficient(List<Integer> numbers){
        return numbers.stream()
                .filter(e -> {
                    System.out.println("GT3 and even: " + e);
                    return e > 3 && e % 2 == 0;
                })
                .map(e -> {
                    System.out.println("times 2: " + e);
                    return e * 2;
                } )
                .findFirst()
                .orElse(0);
    }

    static int getNumber(List<Integer> numbers){
        return numbers.stream()
                .filter(e -> {
                    System.out.println("GT3: " + e);
                    return e > 3;
                })
                .filter(e -> {
                    System.out.println("is Even: " + e);
                    return e % 2 == 0;
                })
                .map(e -> {
                    System.out.println("times 2: " + e);
                    return e * 2;
                } )
                .findFirst()
                .orElse(0);
    }
}