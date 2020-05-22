for (int i = 0; i < contact.length(); i++) {
   JSONObject obj1 = contact.optJSONObject(i);
   ListFeed movie = new ListFeed();

   movie.getuserby(obj1.getString("userby"));
   movie.resid(obj1.getString("reservation_id"));
   movie.setresidinbox(obj1.getString("reservation_id"));
   System.out.println("reservation iddgdsds" + obj1.getString("reservation_id"));
   movie.setuserbys(obj1.getString("userby"));
   movie.setuserto(obj1.getString("userto"));
   movie.setid(obj1.getString("room_id"));
   movie.getid1(obj1.getString("id"));
   movie.userto(obj1.getString("userto"));
   movie.isread(obj1.getString("isread"));
   movie.userbyname(obj1.getString("userbyname"));
   country_symbol = obj1.getString("currency_code");
   Currency c = Currency.getInstance(country_symbol);
   country_symbol = c.getSymbol();
   movie.setsymbol(country_symbol);


   movie.setTitle(obj1.getString("title"));
   movie.setThumbnailUrl(obj1.getString("profile_pic"));
   movie.setstatus(obj1.getString("status"));
   movie.setcheckin(obj1.getString("checkin"));
   movie.setcheckout(obj1.getString("checkout"));
   movie.setcreated(obj1.getString("created"));
   movie.guest(obj1.getString("guest"));
   movie.userbyname(obj1.getString("username"));
   movie.getprice(obj1.getString("price"));
   String msg = obj1.getString("message");
   msg = msg.replaceAll("<b>You have a new contact request from  ", "");
   msg = msg.replaceAll("</b><br><br", "");
   msg = msg.replaceAll("\\w*\\>", "");
   movie.message(msg);

   movieList.add(movie);
   System.out.println(movieList.get(i).message()); // returning unique value

  }