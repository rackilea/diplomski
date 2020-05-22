URL u = new URL("enter url url here");
                HttpURLConnection c = (HttpURLConnection) u.openConnection();
                c.setRequestMethod("GET");
                c.setDoOutput(true);
                c.connect();
                InputStream in = c.getInputStream();