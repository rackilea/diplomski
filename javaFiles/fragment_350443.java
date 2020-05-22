Pattern pattern = Pattern.compile("(?s)\n\\d.*ERROR(\n |.)*");
            Matcher m = tmpPat.matcher(logContent);
            StringBuilder buf = new StringBuilder();
            while (m.find()) {
                String exc = m.group();
                buf.append(exc);
            }