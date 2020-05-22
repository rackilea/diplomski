public class HeaderProblem {

    public static void main(String[] args) {
        List<String> headersFromExcel = Arrays.asList("EMail", "Phone", "Address", "Last Name", "First Name");
        System.out.println(validate(headersFromExcel));
    }

    private static boolean validate(List<String> headers) {
        List<String> mandatoryHeaders = Arrays.asList("First Name", "EMail", "Phone");
        List<String> optionalHeaders = Arrays.asList("Last Name", "Address");
        List<String> allHeaders = new ArrayList<>(mandatoryHeaders);
        allHeaders.addAll(optionalHeaders);
        Map<String, Integer> headerIndexMap = IntStream.range(0, headers.size())
                                                    .boxed()
                                                    .collect(Collectors.toMap(i -> headers.get(i), i -> i));


        if(!allHeaders.containsAll(headers)) {
            System.out.println("Some headers exist which are not allowed");
            return false;
        }

        if (!headers.containsAll(mandatoryHeaders)) {
            System.out.println("Mandatory headers are not present");
            return false;
        }

        System.out.println(mandatoryHeaders.stream()
                .map(headerIndexMap::get)
                .collect(Collectors.toList()));

        // Check if the manadatory headers are in order
        Integer result = mandatoryHeaders.stream()
                        .map(headerIndexMap::get)
                        .reduce(-1, (x, hi) -> x < hi ? hi : headers.size());


        if (result == headers.size()) {
            System.out.println("Mandatory headers are not in order");
            return false;
        }
        return true;
    }

}