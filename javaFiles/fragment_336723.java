//Table name: Score
//Since array size of all parameters will be same as they are dependent on each other, 
//for eg: 5 scores has 5 latitudes & 5 longitudes etc, 
//I got the size of array and looped that many no.of times.

                Score item = null;  
                for(int i=0; i<score.length; i++)
                {
                    long gen_timestamp = Calendar.getInstance().getTimeInMillis();
                    client = DynamoDBConfig.getAmazonDBClient();
                    DynamoDBMapper mapper = new DynamoDBMapper(client);
                    item = new Score();
                    item.setGen_t(gen_timestamp);
                    slf4jLogger.info(i+" Saving gen_timestamp: "+gen_timestamp);
                    item.setDevice_model(device_model);
                    slf4jLogger.info(i+" Saving device_model: "+device_model);
                    item.setApi_key(api_key);
                    slf4jLogger.info(i+" Saving api_key: "+api_key);
                    item.setUser_id(user_id);
                    slf4jLogger.info(i+" Saving user_id: "+user_id);
                    item.setRegistrationId(registrationId);
                    slf4jLogger.info(i+" Saving registrationId: "+registrationId);
                    item.setScore(score[i]);
                    slf4jLogger.info(i+" Saving Score in /receiveUpdateStressScore: "+score[i]);
                    item.setLat(lat[i]);
                    slf4jLogger.info(i+" Saving lat in /receiveUpdateStressScore: "+lat[i]);
                    item.setLon(lon[i]);
                    slf4jLogger.info(i+" Saving lon in /receiveUpdateStressScore: "+lon[i]);
                    item.setAccuracy(accuracy[i]);
                    slf4jLogger.info(i+" Saving accuracy in /receiveUpdateStressScore: "+accuracy[i]);
                    item.setUserLocalTime(userLocalTime[i]);
                    slf4jLogger.info(i+" Saving userLocalTime in /receiveUpdateStressScore: "+userLocalTime[i]);
                    item.setUserTimezone(userTimezone);
                    slf4jLogger.info(i+" Saving userTimezone: "+userTimezone);
                    slf4jLogger.info(i+"Items Saving: "+item);
                    mapper.save(item);  
                }
                slf4jLogger.info("Score Table items: "+item);