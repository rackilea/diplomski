String locale = java.util.Locale.getDefault().getDisplayName();
        if (locale.equalsIgnoreCase("french")) {
            String htmlFileName = "m" + bundle.getString("defStrID") + ".html";
        } else {
            String htmlFileName = "mn" + bundle.getString("defStrID") + ".html";
        }