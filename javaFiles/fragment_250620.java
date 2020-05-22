ContentElement conElement = new ContentElement();

conElement.setPubDate(pubDate); // won't overwrite dates
conElement.setConChannel(conChannel); // and channels now

conList.setConElement(conElement); // every list has its own copy of element