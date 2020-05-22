Element xmlDoc = // ...


/* If 'name' is not relevant you can use "employee > id" instead */
for( Element e : xmlDoc.select("employee > name + id") )
{
    e.text("30");
}

System.out.println(xmlDoc.select("employee"));