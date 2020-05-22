BufferedReader month = new BufferedReader(new InputStreamReader(System.in));
        String mth = month.readLine();
        //Accessing the website
        Document docs = Jsoup.connect("http://forum.toribash.com/clan_war.php?clanid=139").get();

        //Taking every entry of war history
        Elements collection = docs.getElementsByClass("war_history_entry");
        //Itterate every collection
        for(Element e : collection){
            //if the info is on the exact month that are being searched we will use the e
            if(e.getElementsByClass("war_info").text().split(" ")[1].equalsIgnoreCase(mth)){
                // selecting button
                Element button = e.selectFirst("button");
                // getting warid from button id
                String buttonId = button.attr("id");
                // removing text because we need only number
                String warId = buttonId.replace("buttonwarid", "");

                System.out.println("downloading results for " + e.getElementsByClass("war_info").text());
                // downloading and parsing subpage containing table with info about single war
                // adding referrer to make the request look more like it comes from the real web browser to avoid possible hotlinking protection
                Document table = Jsoup.connect("http://forum.toribash.com/clan_war_ajax.php?warid=" + warId + "&clanid=139").referrer("http://forum.toribash.com/clan_war.php?clanid=139").get();
                // get every <td class="player"> ... </td>
                Elements players = table.select(".player");
                for(Element player : players){
                    System.out.println(player.text());
                }
            }
        }