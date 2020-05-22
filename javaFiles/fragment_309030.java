private void copyResponseHeaders(CloseableHttpResponse internResponse, HttpServletResponse response)
    {
        Header[] headers = internResponse.getAllHeaders();
        Header[] connHeaders = internResponse.getHeaders("connection");
        StringBuilder connectionValue = new StringBuilder();

        for (Header connHeader : connHeaders)
        {
            connectionValue.append(connHeader.getValue()).append(", ");
        }

        for (Header header : headers)
        {
            String headerName = header.getName();

            boolean copyAllowed = !forbiddenCopyHeaders.contains(headerName.toLowerCase())
                    && !StringUtils.containsIgnoreCase(connectionValue.toString(), headerName);

            if (copyAllowed)
            {
                if (response.containsHeader(headerName))
                {
                    response.addHeader(headerName, header.getValue());
                }
                else
                {
                    response.setHeader(headerName, header.getValue());
                }
            }
        }

        setViaHeader(internResponse, response);
    }