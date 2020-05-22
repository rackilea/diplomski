Iterator<Page> childPageIterator = Currentpage.listChildren(new PageFilter(request));
while(pageIterator.hasNext())
            {
                Page childPage = pageIterator.next();
                         Resource r = page.getContentResource("image");
                         if (r != null) {
                            Image image = new Image(r);
                            String imagePath = (String)contentpage.getPath()+".img.png"+ image.getSuffix();
                         }
            }