//  create website root **updated** replaced contains with like
  db.command("UPDATE v SET urlSet = \"" + urlRoot + "\", title = \"" + domain + "\", domain = \"" + domain + "\", domainTLD = \"" + domainTLD + "\", dateFluxed = \"" + dateFluxed + "\", urlRoot = \"" + urlRoot +"\" UPSERT WHERE urlSet = \"" + urlRoot + "\"");

  //create edge from website to sub
  db.command ("CREATE EDGE E from \(SELECT FROM v where urlSet like \"" + urlRoot + "\"\) TO \(SELECT FROM V WHERE urlSet like \"" + currentURL + "\"\)");

} else {
  db.command("UPDATE v SET urlSet = \"" + urlRoot + "\", title = \"" + domain + "\", domain = \"" + domain + "\", domainTLD = \"" + domainTLD + "\", dateFluxed = \"" + dateFluxed + "\", urlRoot = \"" + urlRoot +"\" UPSERT WHERE urlSet = \"" + urlRoot + "\"");
}