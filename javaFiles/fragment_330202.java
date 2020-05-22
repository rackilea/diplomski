ArrayList<String> schemeName = new ArrayList<String>();
ArrayList<Integer> schemeId = new ArrayList<Integer>();

...

schemeName.add((rset.getString("scheme_name"));
schemeId.add(Integer.parseInt(rset.getString("id")));