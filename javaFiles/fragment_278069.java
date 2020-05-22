new File(fileName).withWriter { fileWriter ->
    csvFilePrinter = new CSVPrinter(fileWriter, CSVFormat.DEFAULT)
    csvFilePrinter.printRecord(FILE_HEADER)

    BondCounsel.each { b ->
        DiscountRate.each { d ->
            row.each { r ->
                PurchasePrice.each { p ->
                    csvFilePrinter.printRecord([b, d, r, p])
                }
            }
        }
    }
}