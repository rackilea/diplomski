final double min = // some value
final double max = // some other value
List<Double> NormalizedData = 
    Doublevalues1.stream()
                 .map(n -> (((((n-min)/(max-min)))*2)-1))
                 .collect(Collectors.toList());