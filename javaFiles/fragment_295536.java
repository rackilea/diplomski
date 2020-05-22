String strBaseFolder = "C:\\users\\ronjonathan\\desktop\\barcode\\";
            String query = "Select MAX(ProductID) from tblindividualproduct";
            String strBarCodeImageSave = null;

            try

            {
                Document doc = new Document();
                DocumentBuilder docBuilder = new DocumentBuilder(doc);


                // Generate barcode image
                BarCodeBuilder builder = new BarCodeBuilder();
                builder.setSymbologyType(Symbology.Code128);

                pst=con.prepareStatement(query);    
                rs=pst.executeQuery();
                if(rs.next()){
                    int MAX = rs.getInt(1);
                for(int i = 1;i <= Integer.parseInt(txtBarcode.getText()); i++){

                builder.setCodeText(Integer.toString(i+MAX));
                strBarCodeImageSave = +(i+MAX)+".jpg";
                builder.save(strBaseFolder + strBarCodeImageSave);


                docBuilder.insertImage(strBaseFolder + strBarCodeImageSave);
                String strWordFile = "doc.doc";
                doc.save(strBaseFolder + strWordFile);
                }
             // Add the image to a Word doc 

                JOptionPane.showMessageDialog(null, "Success!");