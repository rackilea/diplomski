Intent service = new Intent(this, Request.class);
ArrayList<CharSequence> parameters = new ArrayList<>();
service.putExtra("url", "http://posttestserver.com/post.php?dump&html&sleep=10");
service.putExtra("username", "bob");
service.putExtra("age", "20");
startService(service);