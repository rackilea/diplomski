ArrayList<Object> args = new ArrayList<Object>();
args.add(alphaP);
args.add(bravoP);
args.add(charlieP);
// Add other arguments here...

List<ResultClass> results = (List<ResultClass>) query.executeWithArray(args.toArray());