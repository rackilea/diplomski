// test if we overlap the previous entry.
// Note that we are making an assumption that we need to only look back
// one TextPosition to find what we are overlapping.
// This may not always be true. */
TextPosition previousTextPosition = textList.get(textList.size() - 1);
if (text.isDiacritic() && previousTextPosition.contains(text))
{
    previousTextPosition.mergeDiacritic(text);
}
// If the previous TextPosition was the diacritic, merge it into this
// one and remove it from the list.
else if (previousTextPosition.isDiacritic() && text.contains(previousTextPosition))
{
    text.mergeDiacritic(previousTextPosition);
    textList.remove(textList.size() - 1);
    textList.add(text);
}
else
{
    textList.add(text);
}