String id = "666f6f2d6261722d71757578";
        if (ObjectId.isValid(id)) {
            ObjectId objectId = new ObjectId(id);
            System.out.println(objectId);
        } else {
            System.out.println("Invalid id");
        }