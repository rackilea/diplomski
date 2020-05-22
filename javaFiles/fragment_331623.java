if (!item.getName().trim().equals("")
    && !item.getPrice().trim().equals("")
        && !item.getUrl().trim().equals(""))
{
    if (s.contains(item.getUrl())) {
        system.out.println("url is repeating");
    }
    else {
        dao.insertToDB(item, xmlData.getOutput_DB());
        s.add(item.getUrl());
    }
}
else {
    System.out.println("first loop failedddd");
}