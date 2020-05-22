[...]
            try
            {
                PdfStamper stamper=new PdfStamper(reader,output);
                AcroFields acroFields=stamper.getAcroFields();
                acroFields.setField("fullnameorinitials", editText.getText().toString());
                acroFields.setField("agedob", editText2.getText().toString());
                stamper.close();
            }
            [...]