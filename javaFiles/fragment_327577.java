request.setAttribute("org.apache.catalina.ASYNC_SUPPORTED", true);

        final AsyncContext asyncContext = request.startAsync();
        final PrintWriter writer = response.getWriter();
        asyncContext.setTimeout(60000);
        asyncContext.start(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        List<Row> list = new ArrayList<Row>();
                        list.add(new Row("First", "This is the first", String.valueOf(i), "link" + i));
                        list.add(new Row("Second", "This is the second", String.valueOf(i), "link" + i));
                        list.add(new Row("Third", "This is the third", String.valueOf(i), "link" + i));
                        String json = new Gson().toJson(list);

                        asyncContext.getResponse().setContentType("application/json");
                        asyncContext.getResponse().setCharacterEncoding("UTF-8");
                        try {
                            asyncContext.getResponse().getWriter().write(json);
                            asyncContext.getResponse().getWriter().flush();
                        } catch (IOException ex) {
                            System.out.println("fail");
                        }

                        Thread.sleep(250);
                    } catch (InterruptedException ex) {
                        break;
                    }
                }
                asyncContext.complete();
            }
        });