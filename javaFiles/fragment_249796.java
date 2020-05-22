String input = "<a href=\"http://www.amazon.it/Die-10-Symphonien-Orchesterlieder-Sinfonie-Complete/dp/B003LQSHBO/ref=sr_1_2?ie=UTF8&qid=1440101590&sr=8-2&keywords=mahler\">prodotto di prova</a>\"";
String pattern = "href=(?<link>['\\\"](?:https?:\\/\\/)?(?:www\\.)?(?:amazon|AMAZON)\\.(?:com|it|uk|fr|de)\\/(?<product>:gp\\/product|gp\\/product\\/glance|[^\\/]+\\/dp|dp|[^\\/]+\\/product-reviews)\\/(?<productID>[^\\/]{10})\\/(?<queryString>.*?)\\\")";

Pattern r = Pattern.compile(pattern);
Matcher m = r.matcher(input);

if (m.find( )) {
 System.out.println("Amazon link: " + m.group(0) );
 System.out.println("product: " + m.group("product") );
 System.out.println("productID: " + m.group("productID"));
 System.out.println("querystring: " + m.group("queryString"));
} else {
 System.out.println("NO MATCH");
}