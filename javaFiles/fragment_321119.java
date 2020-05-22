Elements myElements = doc.getElementsByClass("jedalny_listok_tabulka")
                .first().getElementsByTag("td");
        for (Element element : myElements) {
            if (element.className().contains("jedlo")) {
                String foodContent = element.ownText();
                String foodAllergen = "";

                for (Element href : element.getElementsByTag("a")) {
                    foodAllergen += " " + href.text();
                }

                System.out.println(foodContent + " : " + foodAllergen);
            }
        }