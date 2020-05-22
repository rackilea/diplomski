String str = "MYW Pkg, MYW Pkg + Quick Service Dining, MYW Pkg + Dining, MYW Pkg + Deluxe Dining,";
Pattern patPackageDescription = Pattern.compile("([A-Za-z]{3}\\s)+\\+");
Matcher matPackageDescription = patPackageDescription.matcher(str);

while (matPackageDescription.find()) {
    System.out.println(matPackageDescription.group());
}