public void ABData(HttpServletRequest request, HttpServletResponse response) throws Exception {
    try {
        final String Batch_id = request.getParameter("Batch_id");
        try {
            StringBuffer invitationBuffer = new StringBuffer();
            invitationBuffer.append("Batch Name").append(",").append("Campaign Id").append(",").append("Type").append(",").append("Subject Name").append(",").append("Subject Line").append(",").append("Body Template").append(",").append("Sent").append(",").append("Delivered").append(",").append("Bounced").append(",").append("Opens").append(",").append("Clicks").append(",").append("Landing Page Hits").append("\n");
            BasicDataSource dataSource = (BasicDataSource) SpringApplicationContext.getBean("dataSource");
            try (Connection connection = dataSource.getConnection();
                    Statement stmt = connection.createStatement()) {
                String sql = "select b.batch_name,c.campaign_id, ab.ab_test_name, abtxt.subject_line, abtxt.body_template, b.batch_meta_data_id, cpi.campaign_id, cpi.ab_test_id, cpi.user_id, cpi.invitation_id, cpi.date_send, cpi.comm_schedule_id, cpi.comm_type_id from COMM_PROCESS_INFO cpi, BATCHMETADATA b, CAMPAIGN c, ABTEST ab, ABTESTTEXT abtxt where ab.ab_test_id = abtxt.ab_test_id and cpi.ab_test_id = abtxt.ab_test_id and cpi.batch_meta_data_id in (" + Batch_id + ") and b.batch_meta_data_id = cpi.batch_meta_data_id and c.batch_meta_data_id = b.batch_meta_data_id group by cpi.campaign_id,cpi.ab_test_id,cpi.batch_meta_data_id";
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    try (Statement stmtABMetrics = connection.createStatement()) {
                        String sqlABMetrics = "select abmetrics.sent, abmetrics.open, abmetrics.click, abmetrics.signup, abmetrics.bounce, abmetrics.delivered, abmetrics.unsubscribe, abmetrics.spam, abmetrics.landing_page_hits, abmetrics.completions from ABEMAILMETRICS abmetrics where abmetrics.ab_test_id = " + rs.getString("ab_test_id") + " and abmetrics.campaign_id = " + rs.getString("campaign_id") + " and abmetrics.batch_meta_data_id = " + rs.getString("batch_meta_data_id");
                        ResultSet rsABMetrics = stmtABMetrics.executeQuery(sqlABMetrics);
                        if (!rsABMetrics.next()) {
                            invitationBuffer.append(rs.getString("sent")).append(",");
                        }
                    } catch (Exception e) {
                        logger.debug(e, e);
                    }
                    invitationBuffer.append(rs.getString("batch_name")).append(",");
                    invitationBuffer.append(rs.getString("body_template")).append(",").append("\n");
                }
            }
            byte[] b = invitationBuffer.toString().getBytes("UTF-8");
            Properties props = PropertiesUtil.getApplicationProperties();
            StringBuffer strbufMessage = new StringBuffer();
            AlertsUtil.notifyWithCSVAttachment(PropertiesUtil.getApplicationProperties().getProperty("alerts.sendUserForApplicationAlerts"), "sdsdsgamail.com", "Invitation Record ", strbufMessage, invitationBuffer, "Sample.csv", props, false);
        } catch (Exception e) {
            logger.debug(e, e);
        }

        System.out.println("Job is running it will take few mins.You will receive an email to shortly once done ");
    } catch (Exception re) {
        logger.debug(re, re);
    }
}