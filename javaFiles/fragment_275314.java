object missObj = Missing.Value;
            object path = @"D:\mydoc.docx";
            Microsoft.Office.Interop.Word.Application app = new Microsoft.Office.Interop.Word.Application();
            Microsoft.Office.Interop.Word.Document doc = app.Documents.Open(ref path, ref missObj, ref missObj, ref missObj, ref missObj, ref missObj, ref missObj, ref missObj, ref missObj, ref missObj, ref missObj, ref missObj, ref missObj, ref missObj, ref missObj, ref missObj);
            foreach (Microsoft.Office.Interop.Word.Range range in doc.Words)
            {
                if (range.Text.Trim() == "the text")
                {
                    range.HighlightColorIndex = Microsoft.Office.Interop.Word.WdColorIndex.wdDarkYellow;
                    range.Font.ColorIndex = Microsoft.Office.Interop.Word.WdColorIndex.wdWhite;
                }
            }