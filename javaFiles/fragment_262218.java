List<MapElement> elements = conversationResponse.getReturn().getMap();

      for (MapElement mapElement : elements) {

        if (mapElement.getKey() != null
            && mapElement.getKey().equalsIgnoreCase("key2")) {

          val = mapElement.getValue();
          break;
        }

      }