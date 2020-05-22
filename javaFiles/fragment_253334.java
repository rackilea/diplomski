Document doc = Jsoup.connect("https://www.imdb.com/chart/top/").get();
Elements films = doc.select("td.titleColumn");
for (Element film : films) {
    System.out.println(film);
}

<td class="titleColumn"> 1. <a href="/title/tt0111161/?pf_rd_m=A2FGELUUNOQJNL&amp;pf_rd_p=e31d89dd-322d-4646-8962-327b42fe94b1&amp;pf_rd_r=5BDHP4VZE8EGSEZC4ZSF&amp;pf_rd_s=center-1&amp;pf_rd_t=15506&amp;pf_rd_i=top&amp;ref_=chttp_tt_1" title="Frank Darabont (dir.), Tim Robbins, Morgan Freeman">Les évadés</a> <span class="secondaryInfo">(1994)</span> </td>
<td class="titleColumn"> 2. <a href="/title/tt0068646/?pf_rd_m=A2FGELUUNOQJNL&amp;pf_rd_p=e31d89dd-322d-4646-8962-327b42fe94b1&amp;pf_rd_r=5BDHP4VZE8EGSEZC4ZSF&amp;pf_rd_s=center-1&amp;pf_rd_t=15506&amp;pf_rd_i=top&amp;ref_=chttp_tt_2" title="Francis Ford Coppola (dir.), Marlon Brando, Al Pacino">Le parrain</a> <span class="secondaryInfo">(1972)</span> </td>