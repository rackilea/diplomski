Elements actors = E.select("span.movie_info_actors > a");
StringBuffer sb = new StringBuffer();
for (Element actor : actors) {
    sb.append(actor.text());
}
System.out.println(sb.toString());