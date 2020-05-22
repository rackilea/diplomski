for (Element dl : results) {
            if(!dl.text().equals("") && dl.text().length() > 1)
                pNames.add(dl.text());

            if((!dl.select("small").text().equals("")) && dl.select("small").text().length() > 1)
                emails.add((dl.select("small").text()));

            if(!dl.select("span").attr("class").equals("") && dl.select("span").attr("class").length() > 1)
                moneyDollars.add(dl.select("span").attr("class"));
        }