intList = strList.stream()// same with "parallelStream()"
            .map(x -> {
                try {
                    return Integer.parseInt(x);
                } catch (NumberFormatException nfe) {
                    System.err.println(nfe.getMessage());
                }
                return null;
            })
            .filter(x -> x!= null)
            .collect(Collectors.toList());