IList<INode> myNodes = new ArrayList<INode>();
myNodes.add(new SpecificNode());
myNodes.add(new OtherNode());

List<SpecificNode> filteredList = myNodes.stream()
                                         .filter(x -> x instanceof SpecificNode)
                                         .map(n -> (SpecificNode) n)
                                         .collect(Collectors.toList());