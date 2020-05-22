try {
            String content = "";
            Connection conn = DriverManager.getConnection( Host, Name, Pass );  
            PreparedStatement pst = conn.prepareStatement("SELECT * From `news_1`");
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                content = content + rs.getString("title") + "\n";
                content = content + rs.getString("content") + "\n";
                content = content + "\n";
            }
            textArea.setText(content);
        } 
        catch (Exception e) {
        }