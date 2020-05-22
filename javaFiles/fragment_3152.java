package com.google.gwt.text.client;

import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.text.shared.Parser;

import java.text.ParseException;

public class BigDecimalParser implements Parser<BigDecimal> {

  private static BigDecimalParser INSTANCE;

  public static Parser<BigDecimal> instance() {
    if (INSTANCE == null) {
      INSTANCE = new BigDecimalParser();
    }
    return INSTANCE;
  }

  protected BigDecimalParser() {
  }

  public BigDecimal parse(CharSequence object) throws ParseException {
    if ("".equals(object.toString())) {
      return null;
    }

    try {
      return new BigDecimal(object.toString());
    } catch (NumberFormatException e) {
      throw new ParseException(e.getMessage(), 0);
    }
  }
}