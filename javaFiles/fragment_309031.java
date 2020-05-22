private void setViaHeader(CloseableHttpResponse response, HttpServletResponse customerResponse)
    {
        String serverHostName = "companyServer";
        try
        {
            serverHostName = InetAddress.getLocalHost().getHostName();
        }
        catch (UnknownHostException e)
        {
            logger.error("für den VIA-Header kann der Hostname nicht ermittelt werden", e);
            System.err.println("für den VIA-Header kann der Hostname nicht ermittelt werden: " +
                    ExceptionUtils.getStackTrace(e));
        }

        Header[] originalViaHeaders = response.getHeaders("via");
        StringBuilder via = new StringBuilder("");
        if ((originalViaHeaders != null) && (originalViaHeaders.length > 0))
        {
            for (Header viaHeader : originalViaHeaders)
            {
                via.append(viaHeader.getValue()).append(", ");
            }
        }
        via.append(response.getStatusLine().getProtocolVersion().toString()).append(" ").append(serverHostName);

        customerResponse.setHeader("via", via.toString());
    }