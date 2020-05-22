List<String> boys = Files.lines(boyNames)
            .map(name -> name.replaceAll("\\d", "")) // remove numeric values
            .map(name -> name.replaceAll(" ", ""))   // remove spaces
            .collect(Collectors.toList());

 List<String> girls = Files.lines(girlNames)
                .map(name -> name.replaceAll("\\d", "")) // remove numeric values
                .map(name -> name.replaceAll(" ", ""))   // remove spaces
                .collect(Collectors.toList());