private static final List<String> acceptableNames =
    Arrays.asList("low", "lowest", "high");

private List<Label> filterPriorityLabels(List<Label> labels)
{
    for (ListIterator<Label> iter = labels.listIterator(); iter.hasNext();)
    {
        final Label a = iter.next();
        if (!acceptableNames.contains(a.getName())
        {
            iter.remove();
        }
    }

    return labels;
}