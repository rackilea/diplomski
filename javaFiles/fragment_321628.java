String line[] = {"GAASSCC", "EAAASCS", "AAASDAA", "ASBSAA" };
for (String i : line)
    if(i.matches("(?i)^(?:(?!aaa).)*?(?<!a)aa(?!a).*"))
    {
        System.out.println(i +" -> Good");
    }
    else
    {
        System.out.println(i +" -> Bad");
    }