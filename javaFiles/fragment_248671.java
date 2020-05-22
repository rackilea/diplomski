String[] A1 = {"hello","world"};
String[] A2 = {"I","am","bored"};

...

ArrayList<String> temp = new ArrayList<String> (A1.length + A2.length);

temp.addAll (Arrays.asList (A1));
temp.addAll (Arrays.asList (A2));

String[] A3 = temp.toArray (new String[temp.size ()]);

...

for (int i=0; i < A3.length; ++i)
  System.out.println (A3[i]);