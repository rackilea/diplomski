if ((fieldsStr != null) && (fieldsStr.trim().length() > 0)) {
        String[] fields = fieldsStr.split(",");
        for (String field : fields) {
            if (required) {
                int labelID =
                        activity.getResources().getIdentifier(field + "_label", "string",
                                activity.getPackageName());
                StringBuilder hint = new StringBuilder();
                hint.append(activity.getApplicationContext().getString(labelID)).append(
                        " - Required");
                int nameID =
                        activity.getResources().getIdentifier(field, "id",
                                activity.getPackageName());
                EditText v = (EditText)activity.findViewById(nameID);
                v.setHint(hint.toString());
                }
          }
}