String UrlString = URLEncodedUtils.format(nvPair[0], "utf-8");
            URL url = new URL(apiBaseUri + UrlString);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setRequestProperty("User-Agent", "android");
            connection.setRequestProperty("Accept", "application/json");

            connection.setRequestMethod("POST");
            connection.setDoInput(true);
            int responseCode = connection.getResponseCode();
            String response = readResponse(connection);