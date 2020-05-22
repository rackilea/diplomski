static List<Integer> extractInteger(List<String> input) {
        List<Integer> output = new ArrayList<>();

        for (String candidate : input) {
            try {
                output.add(Integer.parseInt(candidate));
            } catch (NumberFormatException e) {

            }
        }

        return output;
    }