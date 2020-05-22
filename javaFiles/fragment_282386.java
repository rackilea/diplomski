int count = 0;
File input = new File("Balbriggan.html");
Document doc = Jsoup.parse(input, "UTF-8", "http://www.cso.ie");

Elements numbers = doc.select("td");
Elements titles = doc.select("th");


for(int i=9; i<titles.size(); i++)
{
    System.out.println("Crime: " + titles.get(i).text());  
    for(int j=0; j<6; j++)
    {
        System.out.println("Figure " + count + ":" + numbers.get((i-9)*6+j).text());
        count++;
    }
}