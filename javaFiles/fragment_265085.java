try (DBCursor cursor = coll_in.find(query)) {
            while (cursor.hasNext()) {
                final DBObject result = cursor.next();
                Map<String, Object> value = (Map<String, Object>) result.get("value");
                System.out.println(value.get("count"));
                System.out.println(value.get("persons"));
            }
        } catch (final MongoException ex) {
            // error
        }