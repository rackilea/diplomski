Page pageContent = pageManager.getContainingPage("/content/my-site/en/cars");
        Iterator<Resource> children = pageContent.getContentResource().listChildren();
        while(children != null && children.hasNext()) {
            Resource child = children.next();
            if(child.isResourceType("foundation/components/parsys") || child.isResourceType("foundation/components/iparsys")) {
                // do something
            }
        }