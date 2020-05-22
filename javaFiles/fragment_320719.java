public static void main(final String[] args)
{
    final String s = "<div><div id=\"mainContent\">foo bar<div>good best better</div>  <div>test test</div></div><div>foo bar</div></div>";
    final Document d = Jsoup.parse(s);
    final Elements e = d.select("#mainContent");
    System.out.println(e.get(0));
}