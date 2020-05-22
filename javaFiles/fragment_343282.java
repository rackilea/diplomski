...
    for (Element td : tdTags) {
                // Print it's text if not empty
                final String text = td.text();
                if (text.isEmpty() == false) {
                    if (td.getElementsByTag("a").first() != null) {
                        // Get the attribute value
                        String url = td.getElementsByTag("a").first().attr("href");

                        // Check for nulls here and take the substring from '=' onwards
                        String id = url.substring(url.indexOf('=') + 1);
                        System.out.println(id + " "+ td.text());
                    }
                    else {
                        System.out.println(td.text());
                    }
                }
            }
...