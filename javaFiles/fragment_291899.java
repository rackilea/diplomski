while (items.hasNext()) {
        FileItem thisItem = (FileItem) items.next();
        if (thisItem.isFormField()) {
            if (thisItem.getFieldName().equals("somefieldname") {
                String value = thisItem.getString();
                // Do something with the value
            }
        }

    }