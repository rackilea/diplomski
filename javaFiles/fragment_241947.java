//We know this is a redirect...
            if(response.getStatus().code() == HttpResponseStatus.FOUND.code()){//When its a 302...

                if(response.headers().names().contains("Location"))
                {
                    System.out.println("We have a redirect...");
                    //Now we will do the process over to get the actual content...
                    Main.main(new String[]{response.headers().get("Location")});
                }
            }