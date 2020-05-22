String sql = "SHOW GLOBAL STATUS LIKE '%conn%'";
            ResultSet rs = null;
            try
            {
                rs = DBUtil.executeQuery(stmt, sql);
                while (rs != null && rs.next())
                {
                    if (StringUtils.equals(rs.getString(1), "Max_used_connections"))
                        return rs.getString(2);
                }
            }
            catch (Exception e)
            {
                throw e;
            }