String SEPARATOR = " ";  // change this as needed, e.g. to tab, comma etc.
TabularData data = ...; // data from the mbean
List<String> list = new ArrayList<String>();  // the output list
for (Object v: data.values()) {
   CompositeData row = (CompositeData)v;
   StringBuilder rowString = new StringBuilder();
   for (Object rv: row.values()) {
       if (rowString.length()!=0)
            rowString.append(SEPARATOR);
       rowString.append(rv);
   }
   list.add(rowString.toString());
}