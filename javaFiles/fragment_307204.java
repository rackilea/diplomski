private static final List<String> acceptableNames =
    Arrays.asList("low", "lowest", "high");

private List<Label> filterPriorityLabels(List<Label> labels)
{
    return labels.stream()
                 .filter( p -> acceptableNames.contains(p.getName()) )
                 .collect(Collectors.toList());
}