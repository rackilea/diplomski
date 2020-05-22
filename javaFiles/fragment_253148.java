try {
            JSONObject obj=new JSONObject();

            obj.put("id", 58);

            JSONObject contact=new JSONObject();
            contact.put("id", "smome value");
            contact.put("first_line", "smome value");
            contact.put("locality", "smome value");

            JSONObject address=new JSONObject();
            address.put("primary_number", "primary");
            address.put("secondary_number", "secondary");

            obj.put("address", address);
            obj.put("contact", contact);
        }catch (Exception e) {
            e.printStackTrace();
        }