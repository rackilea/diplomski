String centers[];

...

List<String> centerList = Arrays.asList(centers);
Set<String> uniqueCenters = new HashSet<String>();
uniqueCenters.addAll(centerList);
uniqueCenters.remove(null);
Integer numberOfUniqueStrings = uniqueCenters.size();