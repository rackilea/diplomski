public void extract(){
        try {
            Connection connection = Jsoup.connect("https://icobench.com/icos");
            Document document = connection.get();
            Elements companyElements = document.select(".ico_data");
            for (Element companyElement : companyElements) {

                if(companyElement.select(".content")!=null&&companyElement.select(".content").size()>0){

                    Element content = companyElement.select(".content").first();
                    String name = companyElement.select(".content").select(".name").text();
                    String description = companyElement.select(".content").select("p").text();
                    String start = companyElement.select("b:contains(Start)").first()
                            .parent().text().replace(companyElement.select("b:contains(Start)").first().text(),"");
                    String end = companyElement.select("b:contains(End)").first()
                            .parent().text().replace(companyElement.select("b:contains(End)").first().text(),"");

                }

                System.out.println(companyElement);
                // do stuff here
                }
        } catch (IOException e) {
            e.printStackTrace();
        }