Iterator<Map.Entry<String, JsonNode>> attributeIterator = dataArray.path("attributes").fields();
            while (attributeIterator.hasNext())
            {
                Map.Entry<String, JsonNode> attribute = attributeIterator.next();
                users.get(id).put(attribute.getKey(),
                        attribute.getValue().get(0).asText());
            }