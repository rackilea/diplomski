// get file path.
FileChooser fc = new FileChooser();
fc.setTitle("Open PDF file...");
fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", "*.pdf"));     
File f = fc.showOpenDialog(stage.getOwner());
String filename = file.getAbsolutePath();

// open file.
PdfDecoder pdf = new PdfDecoder();
pdf.openPdfFile(filename);
showPage(1);
pdf.closePdfFile();

. . . 

/**
 * Update the GUI to show a specified page.
 * @param page 
 */
private void showPage(int page) {

    //Check in range
    if (page > pdf.getPageCount())
        return;
    if (page < 1)
        return;

    //Store
    pageNumber = page;


    //Show/hide buttons as neccessary
    if (page == pdf.getPageCount())
        next.setVisible(false);
    else
        next.setVisible(true);

    if (page == 1)
        back.setVisible(false);
    else
        back.setVisible(true);


    //Calculate scale
    int pW = pdf.getPdfPageData().getCropBoxWidth(page);
    int pH = pdf.getPdfPageData().getCropBoxHeight(page);

    Dimension s = Toolkit.getDefaultToolkit().getScreenSize();

    s.width -= 100;
    s.height -= 100;

    double xScale = (double)s.width / pW;
    double yScale = (double)s.height / pH;
    double scale = xScale < yScale ? xScale : yScale;

    //Work out target size
    pW *= scale;
    pH *= scale;

    //Get image and set
    Image i = getPageAsImage(page,pW,pH);
    imageView.setImage(i);

    //Set size of components
    imageView.setFitWidth(pW);
    imageView.setFitHeight(pH);
    stage.setWidth(imageView.getFitWidth()+2);
    stage.setHeight(imageView.getFitHeight()+2);
    stage.centerOnScreen();
}

/**
 * Wrapper for usual method since JFX has no BufferedImage support.
 * @param page
 * @param width
 * @param height
 * @return 
 */
private Image getPageAsImage(int page, int width, int height) {

    BufferedImage img;
    try {
        img = pdf.getPageAsImage(page);

        //Use deprecated method since there's no real alternative 
        //(for JavaFX 2.2+ can use SwingFXUtils instead).
        if (Image.impl_isExternalFormatSupported(BufferedImage.class))
            return javafx.scene.image.Image.impl_fromExternalImage(img);

    } catch(Exception e) {
        e.printStackTrace();
    }

    return null;
}

/**
 * ===========================================
 * Java Pdf Extraction Decoding Access Library
 * ===========================================
 *
 * Project Info:  http://www.jpedal.org
 * (C) Copyright 1997-2008, IDRsolutions and Contributors.
 *
 *  This file is part of JPedal
 *
    This library is free software; you can redistribute it and/or
    modify it under the terms of the GNU Lesser General Public
    License as published by the Free Software Foundation; either
    version 2.1 of the License, or (at your option) any later version.

    This library is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
    Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public
    License along with this library; if not, write to the Free Software
    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA


 *
 * ---------------
 * JPedalFX.java
 * ---------------
 */