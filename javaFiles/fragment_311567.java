String s = "Passages provides funeral and burial products.\n"
            + "Our products are meant to align with your values and bring you comfort.\n"
            + "Our products allow you to offer personalization , flexibility and innovative choices, helping you provide services to a wider range of customers.";

    s = s.replaceAll("\\s*\\.\\s*\n\\s*", ". ");
    s = s.replaceAll("\\s*,\\s*", ", ");
    s = s.replaceAll("\\s*;\\s*", "; ");
    System.out.println(s);