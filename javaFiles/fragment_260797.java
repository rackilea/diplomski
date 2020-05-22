String a[] = new String[]{"a", "b", "c"};
String b[] = new String[]{"e", "f", "a", "a"};
List<String> matches = new ArrayList<String>();

String hold = "";

for (String anA : a)
    if (!matches.contains(anA))
        for (String aB : b)
            if (anA.equals(aB))
            {
                hold += anA;
                matches.add(anA);
            }//if
    }//for


}//for