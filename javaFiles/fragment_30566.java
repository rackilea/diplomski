MongoCollection<Document> collection  =  db.getCollection(Sensor.KEY_COLLECTION);
    //append sensor data to existing document
    collection.updateOne(doc, new Document("$set",
            new Document("sensor_collection."+String.valueOf(stamp.getCurrentTime()),
                     new Document(
                            Sensor.KEY_LIGHT, sensorData.getLight())
                            .append(Sensor.KEY_PROX, sensorData.getProx())
                            .append(Sensor.KEY_TEMP, sensorData.getTemp())
                    )));