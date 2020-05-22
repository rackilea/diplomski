Object[] r = getRow();

   // data is my dataClass 
   data.inputRowMeta = getInputRowMeta();

    // meta.getField() is a custom method inside my MetaClass for retrieving name of field
    int indexOfValue = data.inputRowMeta.indexOfValue(environmentSubstitute(meta.getField()));

    // Value of field
    data.inputRowMeta.getString(r, data.indexOfValueField);