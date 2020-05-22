scan.setFilter(
  new FilterList(
    FilterList.Operator.MUST_PASS_ONE, 
    new PrefixFilter('xx'), 
    new PrefixFilter('yy')
  )
);