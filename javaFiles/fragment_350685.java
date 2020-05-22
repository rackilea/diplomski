PDAppearanceDictionary appearance = new PDAppearanceDictionary();
COSDictionary dict = new COSDictionary();
dict.setItem(COSName.getPDFName("Off"), new COSDictionary());
dict.setItem(COSName.getPDFName(options.get(i)), new COSDictionary());
PDAppearanceEntry appearanceEntry = new PDAppearanceEntry(dict);
appearance.setNormalAppearance(appearanceEntry);
widget.setAppearance(appearance);