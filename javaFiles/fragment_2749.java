File inputFile = new File("Your-Path");
        this.inputStream = new FileInputStream(inputFile);
        this.opc = OPCPackage.open(this.inputStream);
        this.workbook = WorkbookFactory.create(opc);

...

        this.outputStream = new FileOutputStream(inputFile);
        this.workbook.write(this.outputStream);