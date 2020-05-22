MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
map.set("link", linkUrlString);
map.set("name", "Link Heading");
map.set("caption", "Link Caption");
map.set("description", "Loooooo....ng description here");
map.set("message", "hello world");

// THE BELOW LINES ARE THE CRITICAL PART I WAS LOOKING AT!
map.set("picture", "http://www.imageRepo.com/resources/test.png"); // the image on the left
map.set("actions", "{'name':'myAction', 'link':'http://www.bla.com/action'}"); // custom actions as JSON string

publish(userIdToPostTo, "feed", map);