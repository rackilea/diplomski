StringBuilder fcmServerResponse = new StringBuilder();

    BufferedReader in = new BufferedReader(
                        new InputStreamReader(conn.getInputStream()));

                String inputLine;


                while ((inputLine = in.readLine()) != null) {
                    fcmServerResponse.append(inputLine);
                }

     fcmServerResponse.toString()//This is response from FCM