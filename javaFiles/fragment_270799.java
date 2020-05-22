final Set<Survey> surveySet = null;
final List<Survey> sortedList = surveySet.stream()
            .sorted(Comparator.comparing(Survey::getCreatedDate).reversed())
            .collect(Collectors.toList());

final SortedSet<Survey> sortedSet = surveySet.stream()
            .collect(Collectors.toCollection(
                    () -> new TreeSet<>(Comparator.comparing(Survey::getCreatedDate).reversed())));