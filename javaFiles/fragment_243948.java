Charset charset = Charset.forName("UTF-8");
MultipartEntity entity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE, null, charset);
entity.addPart("restaurantName", new StringBody(restaurant.getRestaurantName(), charset));
entity.addPart("postLeitZahl", new StringBody(restaurant.getPostLeitZahl(), charset));
entity.addPart("phoneNumber", new StringBody(restaurant.getPhoneNumber(), charset));
entity.addPart("id", new StringBody(restaurant.getId(), charset));

HttpPost post = new HttpPost(url);
post.setEntity(entity);
response = client.execute(post);