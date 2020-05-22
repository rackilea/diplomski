if (entry.getName().equals("xl/worksheets/sheet1.xml"))
        {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            IOUtils.copy(zipInput, bos);
            String xml = bos.toString();
            assert xml.contains("A1");
            assert xml.contains("B2");
            assert xml.contains("C3");
            break;
        }