try
    {
        imageScanningBean = jdbcTemplate.queryForObject("select * from tablename", new Object[]{imageScanningBean.getTellerId()},new BeanPropertyRowMapper<ImageScanningBean>(){
            public ImageScanningBean mapRow(ResultSet rs, int rowNum) throws SQLException {
                Blob image;
                ImageScanningBean imageScanningBean = new ImageScanningBean();
                image = rs.getBlob("IMAGEOUT");
                StringBuffer strOut = new StringBuffer();
                try
                {
                    String aux;
                    BufferedReader br = new BufferedReader(new InputStreamReader(image.getBinaryStream()));
                    while ((aux=br.readLine())!=null) 
                    {
                        strOut.append(aux);
                    }
                    strOut.toString();
                    imageScanningBean.setImageOutBase64(strOut.toString());
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
                return imageScanningBean;
            }
        });
    } 
    catch(EmptyResultDataAccessException er)
    {
        er.printStackTrace();
        return imageScanningBean;
    }