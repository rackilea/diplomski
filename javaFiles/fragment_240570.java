StringBuilder builder = new StringBuilder();
            builder.append("{\"id\" :");
            builder.append(id);
            builder.append(", \"latitude\" :");
            builder.append(latitude);
            builder.append(", \"longitude\" :");
            builder.append(longitude);
            builder.append("}");
        return builder.toString();