try {           
        if (System.getProperty("os.arch").contains("64")) {
            System.load(DLL_64BIT_PATH);
        } else {
            System.load(DLL_32BIT_PATH);
        }
    } catch (UnsatisfiedLinkError e) {
        //TODO          
    } catch (IOException e) {
        //TODO          
    }

 ActiveXComponent oleComponent = new ActiveXComponent("Word.Application");
 oleComponent.setProperty("Visible", false);
 Variant var = Dispatch.get(oleComponent, "Documents");
 Dispatch document = var.getDispatch();

 Dispatch activeDoc = Dispatch.call(document, "Open", fileName).toDispatch();

// https://msdn.microsoft.com/EN-US/library/office/ff845579.aspx
Dispatch.call(activeDoc, "ExportAsFixedFormat", new Object[] { "path to pdfFile.pdf", new Integer(17), false, 0 });
Object args[] = { new Integer(0) };//private static final int DO_NOT_SAVE_CHANGES = 0;
Dispatch.call(activeDoc, "Close", args); 
Dispatch.call(oleComponent, "Quit");