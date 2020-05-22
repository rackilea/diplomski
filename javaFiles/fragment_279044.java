double m00 = Double.parseDouble(num00.getText());
        double m10 = Double.parseDouble(num10.getText());
        double m01 = Double.parseDouble(num01.getText());
        double m11 = Double.parseDouble(num11.getText());
        double m02 = Double.parseDouble(num02.getText());
        double m12 = Double.parseDouble(num12.getText());
        AffineTransform transform = new AffineTransform(m00, m10, m01, m11,
                m02, m12);