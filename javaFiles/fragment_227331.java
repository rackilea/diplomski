public List<MainGridItem> fruitItem = new ArrayList<>();
    Handler handler = new Handler();


        Thread downloadThread = new Thread(new Runnable() {
            @Override
            public void run() {
                Document doc = null;
                try {
                    doc = Jsoup
                            .connect("http://banana-mango.com/hello.htm")
                            .get();
                    Elements fruits = doc.select("p[align=center]");
                    for (int i = 0; i < fruits.size(); i++) {
                        MainGridItem gr = new MainGridItem(fruitItem.get(i).select("img").attr("abs:src"),fruitItem.get(i).text().trim(),fruitItem.get(i).select("a").attr("abs:href"));
                        //System.out.println(gr.getStuff+gr.getMore+gr.getAgain);
                        fruitItem.add(gr);
                    }
               handler.post(new Runnable() {
                    @Override
                    public void run() {
                        // Access your arrayList Here and do Ui stuff
                    }
                });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        downloadThread.start();