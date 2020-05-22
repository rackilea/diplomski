Map<String, String> headers = new HashMap<>();
            headers.put("Authorization", "Basic <BASE64_ENCODED_AUTH_TOKEN>");
            headers.put("Accept-Ranges", "bytes");
            headers.put("Status", "206");
            headers.put("Cache-control", "no-cache");

            Uri uri = Uri.parse(url);
            mediaPlayer.setDataSource(getContext(), uri, headers);