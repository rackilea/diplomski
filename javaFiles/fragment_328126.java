try {
            String urlLogin = "https://www.digikey.it/classic/RegisteredUser/Login.aspx?ReturnUrl=%2fclassic%2fregistereduser%2fmydigikey.aspx%3fsite%3dit%26lang%3dit&site=it&lang=it";
            Connection.Response response = Jsoup.connect(urlLogin)
                    .method(Connection.Method.GET)
                    .execute();


            Document loginPage = response.parse();

            Element eventValidation = loginPage.select("input[name=__EVENTVALIDATION]").first();
            Element viewState = loginPage.select("input[name=__VIEWSTATE]").first();


            response = Jsoup.connect(urlLogin)
                    .data("__VIEWSTATE", viewState.attr("value"))
                    .data("__EVENTVALIDATION", eventValidation.attr("value"))
                    .data("ctl00$ctl00$mainContentPlaceHolder$mainContentPlaceHolder$txtUsername", "username")
                    .data("ctl00$ctl00$mainContentPlaceHolder$mainContentPlaceHolder$txtPassword", "password")
                    .data("ctl00$ctl00$mainContentPlaceHolder$mainContentPlaceHolder$btnLogin", "Accesso")
                    .method(Connection.Method.POST)
                    .followRedirects(true)
                    .execute();

            Document document = response.parse();
            Element liElement = document.select("li#welcome_name").first();

            System.out.println(liElement.html());

        } catch (IOException e) {
            e.printStackTrace();
        }