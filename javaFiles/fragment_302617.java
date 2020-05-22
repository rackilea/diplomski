Resource resource = resourceResolver
            .getResource("/content/dam/collections/k/kXjI0j44sW4pq2mWc9fE/public collections");
    if (null != resource) {
        log.debug("resource path is {}", resource.getPath());
        ResourceCollection resourceCollection = resource.adaptTo(ResourceCollection.class);
        if (null != resourceCollection) {
            Iterator<Resource> resourceIterator = resourceCollection.getResources();
            while (resourceIterator.hasNext()) {
                Resource damResource = resourceIterator.next();
                log.debug("damResource path is {}", damResource.getPath());
                imagePaths.add(damResource.getPath());
            }
        }
    }