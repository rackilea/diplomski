public int compare(CustomClass o1, CustomClass o2)
{
  return ComparisonChain.start()
    .compare(o1.getCreateDate(), o2.getCreateDate(), Ordering.natural().nullsLast())
    .result();
}