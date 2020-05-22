package com.itextpdf.samples;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.itextpdf.forms.PdfAcroForm;
import com.itextpdf.forms.PdfPageFormCopier;
import com.itextpdf.forms.fields.PdfFormField;
import com.itextpdf.io.font.FontProgram;
import com.itextpdf.io.font.FontProgramFactory;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.WriterProperties;

public class Test {

    public static void main(String[] args) throws IOException {
        FontProgram fontProgram = FontProgramFactory.createFont("c:/windows/fonts/msgothic.ttc,1");

        FileOutputStream outputStream = new FileOutputStream("test.pdf");
        WriterProperties wp = new WriterProperties();
        wp.useSmartMode();
        try (PdfDocument writeDoc = new PdfDocument(new PdfWriter(outputStream, wp))) {

            for (int keyNumber = 0; keyNumber < 3; keyNumber++) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                try (PdfWriter writer = new PdfWriter(baos);
                    PdfDocument readDoc =
                        new PdfDocument(new PdfReader("form.pdf"), writer)) {
                    PdfAcroForm pdfAcroForm = PdfAcroForm.getAcroForm(readDoc, false);
                    Map<String, PdfFormField> fieldMap = pdfAcroForm.getFormFields();
                    if (fieldMap != null && fieldMap.size() > 0) {    
                        Set<String> fieldNameSet = new HashSet<>(fieldMap.keySet()); 
                        for (String fieldName : fieldNameSet) {
                            pdfAcroForm.renameField(fieldName, fieldName + "_" + keyNumber);
                        }
                        fieldMap = pdfAcroForm.getFormFields();
                    }

                    PdfFormField form = fieldMap.get("name_" + keyNumber);              
                    form.setFont(PdfFontFactory.createFont(fontProgram)).setValue("Test Test");
                }


                try (PdfDocument readDoc =
                    new PdfDocument(new PdfReader(new ByteArrayInputStream(baos.toByteArray())))) {
                    readDoc.copyPagesTo(1, readDoc.getNumberOfPages(), writeDoc, new PdfPageFormCopier());
                }
            }
        }
    }
}