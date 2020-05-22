JsonObject obj1 = new JsonObject();
                    JsonElement element = data.toJsonTree(imgstr);
                    obj1.add("image", element);
                    obj1.add("html", element1

                    out.write(obj1.toString());