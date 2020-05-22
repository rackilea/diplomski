package com.h2s.service.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;


public class ExcelCellStyle {

    private HSSFCellStyle defaultCellStyle = null;
    private Map<Integer, HSSFCellStyle> mapColoredStyles = new HashMap<>();
    private HSSFWorkbook workBook = null;
    private HSSFCellStyle defaultCellStyleForTitle = null;
    private HSSFCellStyle defaultCellStyleForBigTitle = null;
    private HSSFFont bigFont;

    private ExcelCellStyle(){
    }

    public static ExcelCellStyle getInstance(){
        return new ExcelCellStyle();
    }

    public HSSFCellStyle getDefaultCellStyle() {
        if(defaultCellStyle == null){
            generateDefaultStyle();
        }
        return defaultCellStyle;
    }

    private void generateDefaultStyle() {
        defaultCellStyle = workBook.createCellStyle();
        defaultCellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        defaultCellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        defaultCellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        defaultCellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
    }

    public HSSFCellStyle getColoredCellStyle(short index) {
        if(!mapColoredStyles.containsKey(index)){
            HSSFCellStyle newCellStyle = workBook.createCellStyle();
            newCellStyle.setFillForegroundColor(index);
            newCellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
            mapColoredStyles.put((int) index, newCellStyle);
        }
        return mapColoredStyles.get((int)index);
    }

    public void setWorkBook(HSSFWorkbook wb) {
        this.workBook  = wb;
    }

    public HSSFCellStyle getDefaultCellStyleForTitle() {
        if(defaultCellStyleForTitle == null){
            defaultCellStyleForTitle = workBook.createCellStyle();
            defaultCellStyleForTitle.setBorderRight(HSSFCellStyle.BORDER_THICK);
            defaultCellStyleForTitle.setBorderLeft(HSSFCellStyle.BORDER_THICK);
            defaultCellStyleForTitle.setBorderBottom(HSSFCellStyle.BORDER_THICK);
            defaultCellStyleForTitle.setBorderTop(HSSFCellStyle.BORDER_THICK);
        }
        return defaultCellStyleForTitle;
    }

    public HSSFCellStyle getDefaultCellStyleForBigTitle() {
        if(defaultCellStyleForBigTitle == null){
            defaultCellStyleForBigTitle = workBook.createCellStyle();
            defaultCellStyleForBigTitle.setBorderRight(HSSFCellStyle.BORDER_THICK);
            defaultCellStyleForBigTitle.setBorderLeft(HSSFCellStyle.BORDER_THICK);
            defaultCellStyleForBigTitle.setBorderBottom(HSSFCellStyle.BORDER_THICK);
            defaultCellStyleForBigTitle.setBorderTop(HSSFCellStyle.BORDER_THICK);
            defaultCellStyleForBigTitle.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
            defaultCellStyleForBigTitle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
            defaultCellStyleForBigTitle.setFont(getBigFont());
            defaultCellStyleForBigTitle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
            defaultCellStyleForBigTitle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        }
        return defaultCellStyleForBigTitle;
    }

    private HSSFFont getBigFont() {
        if(bigFont == null){
            bigFont = workBook.createFont();
            bigFont.setFontHeightInPoints((short) 28);
            bigFont.setFontName("Calibri");
        }
        return bigFont;
    }
}