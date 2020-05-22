// Check if COSDictionary has '/ProcSet [/PDF /Text]' string in the stream
        private static boolean isXobjectHasTextFieldInPdf(COSDictionary dictionary) {
            boolean isHasTextField = false;
            for (COSBase cosBase : dictionary.getValues()) {
                // go to a recursion because COSDictionary can have COSDictionaries inside
                if (cosBase instanceof COSDictionary) {
                    COSDictionary cosDictionaryNew = (COSDictionary) cosBase;
                    // check if '/ProcSet' has '/Text' param
                    if (cosDictionaryNew.containsKey(COSName.PROC_SET)) {
                        COSBase procSet = cosDictionaryNew.getDictionaryObject(COSName.PROC_SET);
                        if (procSet instanceof COSArray) {
                            for (COSBase procSetIterator : ((COSArray) procSet)) {
                                if (procSetIterator instanceof COSName
                                        && ((COSName) procSetIterator).getName().equals("Text")) {
                                    return true;
                                }
                            }
                        } else if (procSet instanceof COSString && ((COSString) procSet).getString().equals("Text")) {
                            return true;
                        }
                    }
                    // go to the COSDictionary children
                    isHasTextField = isXobjectHasTextFieldInPdf(cosDictionaryNew);
                }
            }
            return isHasTextField;
        }