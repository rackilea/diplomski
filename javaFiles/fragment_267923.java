//Will hold an array of references
PdfArray refs = null;

//If we have an array, use it directly
if (dictionary.Get(PdfName.CONTENTS).IsArray()) {
    refs = dictionary.GetAsArray(PdfName.CONTENTS);
//If we have just a reference, wrap it in a single item array for convenience
} else if (dictionary.Get(PdfName.CONTENTS).IsIndirect()) {
    refs = new PdfArray(dictionary.Get(PdfName.CONTENTS));
//Sanity check, should never happen for conforming PDFs
} else {
    throw new ApplicationException("Unknown CONTENTS types");
}

//Loop through each reference
foreach (var r in refs) {
    //Same code here
    reference = (PRIndirectReference)r;
    contentStream = (PRStream)PdfReader.GetPdfObject(reference);
    byteStream.Add(PdfReader.GetStreamBytes(contentStream));
}