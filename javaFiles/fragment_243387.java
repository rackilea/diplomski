SearchResponse response = client
            .prepareSearch(index)
            .setPostFilter( FilterBuilders.hasChildFilter(type,FlterBuilders
                            .geoBoundingBoxFilter("point")
                            .bottomRight(bottomRightLatitude,bottomRightLongitude)
                            .topLeft(topLeftLatitude,topLeftLongitude))).execute()
            .actionGet();