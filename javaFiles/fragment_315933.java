try {
            document = Jsoup.connect("http://afterlifesolutions.com/theaterstore/app-featured.php").get();
            Elements links = document.getElementsByClass("single-product");
            for (Element element : links) {
                Data data = new Data(); //class where I set and get the data, of course you don't have to follow this patern

                Elements getLink = element.select("a.product_link[href]");
                String link = getLink.attr("abs:href");
                Elements getImage = element.select("img.product_poster[src]");
                String image = getImage.attr("abs:src");
                String title = element.select("p.product_name").text();
                String price = element.select("p.product_price").text();
                Log.d(image, title);
                data.setUrl(link);
                data.setTopic(title);
                data.setBitmap(getBitmap(image));
                datas.add(data);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
     }