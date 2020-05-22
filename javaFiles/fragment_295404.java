class Person implements CsvPrintable {

String name;
int age;
Address address;

@Override
printCsv() {
   return StringBuilder().append(name).append(CSV_SEPARATOR)
                         .append(age).append(CSV_SEPARATOR)
                         .append(address.printCsv()).toString();
   }
}