String str = "String m_sFoo;\n"
        + "Array m_arrKeepThings;\n"
        + "List<? extends Reader> m_lstReaders; // A silly comment\n"
        + "String.format(\"Hello World!\"); /* No m_named vars here */";
// Read the file you want to handle instead

NameMatcher nm = new NameMatcher(str);
System.out.println(nm.performReplacements());