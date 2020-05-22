String htmlString = "<div class=\"WordSection1\"> <p class=\"MsoNormal\">Hi<br> <br> <br> <br> Data is written in this mail.<br> <br> <br> <br> <o:p></o:p></p> </div>";

htmlString = htmlString.replaceAll("<br>", System.getProperty("line.separator") + "<br>"); // do replacements for all tags that should result in line-breaks

Document.OutputSettings settings = new OutputSettings();
settings.prettyPrint(false); // to keep line-breaks

String cleanedSource = Jsoup.clean(htmlString, "", Whitelist.none(), settings);

System.out.println(cleanedSource);