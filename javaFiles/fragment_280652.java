package com.ssaurel.samples.excel;

import java.io.File; 

import java.io.FileInputStream;

import java.io.IOException;

import java.util.Iterator;


import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcel {

  public static void main(String[] args) throws IOException {
    File excelFile = new File("contacts.xlsx");
    FileInputStream fis = new FileInputStream(excelFile);

    // we create an XSSF Workbook object for our XLSX Excel File
    XSSFWorkbook workbook = new XSSFWorkbook(fis);

    // ...

  }

}