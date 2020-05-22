public static findByCharacteristics(final String[] characteristics)
{
    for (final Fruits candidate: values())
        if (candidate.color.equals(characteristics[0])
            && candidate.shape.equals(characteristics[1])
            && candidate.category.equals(characteristics[2]))
            return candidate:
    return null;
}