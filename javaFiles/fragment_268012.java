Uri u = Uri.parse(newURL)
                .buildUpon()
                .appendQueryParameter("param", param)
                .build();

String url = u.toString();