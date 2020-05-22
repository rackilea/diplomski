AcroFields form = stamper.getAcroFields();
        for(Entry<String, Item> field : form.getFields().entrySet()) {
            System.out.println(field.getKey() + ": " + field.getValue());
            String[] values = form.getAppearanceStates(field.getKey());
            StringJoiner sb = new StringJoiner(",");
            for (String value : values) {
                sb.add(value);
            }
            System.out.println("Possible Options: " + sb.toString());
        }